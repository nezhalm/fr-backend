package com.example.filrouge.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class offreRequest {
    private String title;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String level;
    private String experience;
    private Long entrepriseId;
    private Long categoryId;

    // Getters and Setters
}
