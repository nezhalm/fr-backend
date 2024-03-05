package com.example.filrouge.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "test")
    private Offer offer;
}
