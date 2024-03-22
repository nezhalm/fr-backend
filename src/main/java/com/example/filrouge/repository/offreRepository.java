package com.example.filrouge.repository;

import com.example.filrouge.model.Entreprise;
import com.example.filrouge.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface offreRepository extends JpaRepository<Offer, Integer> {
    Set<Offer> findByEntreprise(Entreprise entreprise);

}