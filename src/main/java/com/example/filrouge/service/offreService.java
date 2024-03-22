package com.example.filrouge.service;

import com.example.filrouge.dtos.request.offreRequest;
import com.example.filrouge.model.Entreprise;
import com.example.filrouge.model.Offer;

import java.util.List;
import java.util.Set;

public interface offreService {
    Offer addOffer(Offer offer);

     Offer updateOffer(Offer offer);

     List<Offer> getOffers();

     void deleteOffer(Integer id);

     Offer getById(Long id);

     Set<Offer> getOffersOfCompany(Entreprise entreprise);
}