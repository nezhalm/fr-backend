package com.example.filrouge.model;
import com.example.filrouge.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="candidat")
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullname;
	private String email;
	private String phone;
	private String letter;
	private String filename;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "cv_url")
	private String cvUrl; // Added CV attribute
	@ManyToOne(fetch = FetchType.EAGER)
	private Offer offer;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	public Candidat() {
	}

	public Candidat(String fullname, String email, String phone, String letter, String filename, Offer offer, Date date) {

		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.letter = letter;
		this.filename = filename;
		this.offer = offer;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
