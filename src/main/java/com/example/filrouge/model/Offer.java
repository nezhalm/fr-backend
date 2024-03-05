package com.example.filrouge.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
@Table(name = "job_offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String requiredSkills;
    private String benefits;
    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;


}
