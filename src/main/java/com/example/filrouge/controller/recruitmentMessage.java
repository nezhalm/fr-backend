package com.example.filrouge.controller;

import com.example.filrouge.model.Candidat;
import com.example.filrouge.model.Offer;
import com.example.filrouge.model.Recruiter;
import com.example.filrouge.model.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "recruiter_messages")
public class recruitmentMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private User recruiter;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidat candidate;

    @ManyToOne
    @JoinColumn(name = "recruitment_offer_id")
    private Offer recruitmentOffer;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_at")
    private Date sentAt;

    // Getters and setters
}
