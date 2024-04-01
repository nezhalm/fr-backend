package com.example.filrouge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String educationLevel;

    private String degrees;

    private String institutions;

    private String graduationYears;

    private String jobTitles;

    private String companies;

    private String employmentStartDates;

    private String employmentEndDates;

    private String responsibilities;

    private String skills;

    private String summary;
    private String website;
    private String linkedInProfile;

    private String preferredIndustries;

    private String preferredJobTypes;

    private String availability;

    // Ajoutez les constructeurs, getters et setters nécessaires
}
