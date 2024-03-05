package com.example.filrouge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Recruiter extends User {

    @ManyToOne
    private Company company;

}
