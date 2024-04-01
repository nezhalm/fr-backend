package com.example.filrouge.controller;
import com.example.filrouge.model.ChatMessage;
import com.example.filrouge.model.RecruitmentMessage;
import com.example.filrouge.service.chatMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class chatMessageController {
    private final chatMessageService chatService;

    public chatMessageController(chatMessageService chatService) {
        this.chatService = chatService;
    }


    @GetMapping
    public ResponseEntity<List<RecruitmentMessage>> getAllMessages() {
        List<RecruitmentMessage> messages = chatService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruitmentMessage> getMessageById(@PathVariable Long id) {
        return chatService.getMessageById(id)
                .map(message -> new ResponseEntity<>(message, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("byOffer/{id}")
    public ResponseEntity<List<RecruitmentMessage>> getMessageByOfferId(@PathVariable Long id) {
       List<RecruitmentMessage>  chat =  chatService.getMessageByOfferId(id);
        return new ResponseEntity<>(chat, HttpStatus.OK);

    }



    @PostMapping
    public ResponseEntity<RecruitmentMessage> createMessage(@RequestBody RecruitmentMessage message) {
        RecruitmentMessage createdMessage = chatService.saveMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        chatService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
