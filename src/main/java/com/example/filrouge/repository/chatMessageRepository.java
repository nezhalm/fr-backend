package com.example.filrouge.repository;

import com.example.filrouge.model.ChatMessage;
import com.example.filrouge.model.RecruitmentMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chatMessageRepository extends JpaRepository<RecruitmentMessage, Long> {
    List<RecruitmentMessage> findByRecruitmentOfferId(Long id);

}
