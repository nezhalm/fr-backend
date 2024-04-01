package com.example.filrouge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

@Entity
@Table(name="formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String address;
	private String date;
	private int duration;

	@ManyToOne(fetch = FetchType.EAGER)
	private Entreprise entreprise;

	@ManyToOne(fetch = FetchType.EAGER)
	private Candidat candidat;
	


}
