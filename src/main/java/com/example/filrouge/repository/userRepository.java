package com.example.filrouge.repository;

import com.example.filrouge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String username);
    Optional<User> findById(int num);
}
