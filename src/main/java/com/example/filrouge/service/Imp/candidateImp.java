package com.example.filrouge.service.Imp;

import com.example.filrouge.model.Candidat;
import com.example.filrouge.model.Offer;
import com.example.filrouge.model.User;
import com.example.filrouge.repository.condidatRepository;
import com.example.filrouge.repository.userRepository;
import com.example.filrouge.service.candidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class candidateImp implements candidateService {
    @Autowired
    private condidatRepository candidatRepository;
    private userRepository uRepository;

    @Override
    public Candidat addCandidat(Candidat candidat) {

        return this.candidatRepository.save(candidat);
    }

    @Override
    public List<Candidat> getCandidats() {

        return this.candidatRepository.findAll();
    }

    @Override
    public void deleteCandidat(Integer id) {

        this.candidatRepository.deleteById(id);
    }
    public Candidat findByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }
    @Override
    public Candidat findById(Integer id) {

        return this.candidatRepository.findById(id).get();
    }
    @Override
    public Set<Candidat> getCandidatsOfOffer(Offer offer) {
        return null;
    }

    @Override
    public List<Candidat> getUsersByOfferId(Long offerId) {
        return candidatRepository.findByOfferId(offerId);
    }
}
