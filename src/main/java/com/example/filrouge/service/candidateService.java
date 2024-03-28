package com.example.filrouge.service;

import com.example.filrouge.model.Candidat;
import com.example.filrouge.model.Offer;
import com.example.filrouge.model.User;

import java.util.List;
import java.util.Set;

public interface candidateService {
    public Candidat addCandidat(Candidat candidat);

    public List<Candidat> getCandidats();

    public Candidat findByEmail(String email);


    public void deleteCandidat(Integer id);

    public Candidat findById(Integer id);

    public Set<Candidat> getCandidatsOfOffer(Offer offer);
    public List<Candidat> getUsersByOfferId(Long offerId) ;

}
