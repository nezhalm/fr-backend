package com.example.filrouge.repository;
import com.example.filrouge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);

    long countByEmail(String email); // Ajouter cette méthode

    Optional<User> findById(int num);

}
