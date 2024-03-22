package com.example.filrouge.repository;
import com.example.filrouge.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface companyRepository extends JpaRepository<Entreprise, Long> {
    Optional<Entreprise> findByName(String name);

}


