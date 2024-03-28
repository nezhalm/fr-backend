package com.example.filrouge.repository;

import com.example.filrouge.model.Candidat;
import com.example.filrouge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface condidatRepository extends JpaRepository<Candidat, Integer> {
    Candidat findByEmail(String email);
    List<Candidat> findByOfferId(Long offerId);

}
