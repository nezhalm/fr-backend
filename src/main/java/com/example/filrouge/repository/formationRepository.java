package com.example.filrouge.repository;

import com.example.filrouge.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface formationRepository extends JpaRepository<Formation, Long> {

    Optional<Formation> findByTitle(String title);
}
