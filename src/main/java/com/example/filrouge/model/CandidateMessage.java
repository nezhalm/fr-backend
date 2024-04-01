package com.example.filrouge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "candidate_messages")
public class CandidateMessage {

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
