package com.example.filrouge.repository;

import com.example.filrouge.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface condidatRepository extends JpaRepository<Candidat, Integer> {
    Candidat findByEmail(String email);

}
