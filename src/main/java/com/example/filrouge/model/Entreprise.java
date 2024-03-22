package com.example.filrouge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name="entreprise")
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "id")
	private Long id;
	private String name;
	private String description;
	private String address;
	private String fileName;
	private String type;

	@ManyToOne
	private User recruiter;
	//image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	//@Column(name = "picByte", length = 1000)
	private byte[] picByte;
	
	@OneToMany(mappedBy="entreprise", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Formation> formations = new LinkedHashSet<>();
	
	@OneToMany(mappedBy="entreprise", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Offer> offers = new HashSet<>();

	public Entreprise() {
	}

	public Entreprise(String name, String description, String address, String fileName, String type, byte[] picByte) {
		
		this.name = name;
		this.description = description;
		this.address = address;
		this.fileName = fileName;
		this.type = type;
		this.picByte = picByte;
	}

}
