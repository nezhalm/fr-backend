package com.example.filrouge.service.Imp;

import com.example.filrouge.model.ChatMessage;
import com.example.filrouge.model.RecruitmentMessage;
import com.example.filrouge.repository.chatMessageRepository;
import com.example.filrouge.service.chatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class chatMessageImp implements chatMessageService {
    private final chatMessageRepository chatRepository;

    public chatMessageImp(chatMessageRepository chatRepository) {
        this.chatRepository = chatRepository;
    }


    public List<RecruitmentMessage> getAllMessages() {
        return chatRepository.findAll();
    }

    public List<RecruitmentMessage> getMessageByOfferId(Long id) {
        return chatRepository.findByRecruitmentOfferId(id);
    }
    public Optional<RecruitmentMessage> getMessageById(Long id) {
        return chatRepository.findById(id);
    }

    public RecruitmentMessage saveMessage(RecruitmentMessage message) {
        return chatRepository.save(message);
    }

    public void deleteMessage(Long id) {
        chatRepository.deleteById(id);
    }
}
