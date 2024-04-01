package com.example.filrouge.service;

import com.example.filrouge.model.ChatMessage;
import com.example.filrouge.model.RecruitmentMessage;

import java.util.List;
import java.util.Optional;

public interface chatMessageService {
    List<RecruitmentMessage> getAllMessages();

    Optional<RecruitmentMessage> getMessageById(Long id);

    RecruitmentMessage saveMessage(RecruitmentMessage message);

    void deleteMessage(Long id);
    public List<RecruitmentMessage> getMessageByOfferId(Long id) ;
}
