package com.example.filrouge.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "candidates")
public class Candidate extends User {
    private String skills;
    private String experience;
    private String education;
}