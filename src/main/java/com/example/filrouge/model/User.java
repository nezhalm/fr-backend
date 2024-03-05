package com.example.filrouge.model;
import com.example.filrouge.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@Table(name = "users")
public abstract class User {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String city;
    @Enumerated(EnumType.STRING)
    private Role role;

}
