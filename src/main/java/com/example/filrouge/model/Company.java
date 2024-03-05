package com.example.filrouge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    private String industry;
    private String location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Offer> jobOffers;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Recruiter> recruiters;

}