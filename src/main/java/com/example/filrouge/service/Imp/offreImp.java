package com.example.filrouge.service.Imp;
import com.example.filrouge.dtos.request.offreRequest;
import com.example.filrouge.model.Category;
import com.example.filrouge.model.Entreprise;
import com.example.filrouge.model.Offer;
import com.example.filrouge.repository.categoryRepository;
import com.example.filrouge.repository.companyRepository;
import com.example.filrouge.repository.offreRepository;
import com.example.filrouge.service.offreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class offreImp implements offreService {
    @Autowired
    private offreRepository offerRepository;

    @Autowired
    private companyRepository entrepriseRepository;
    @Autowired
    private categoryRepository catRepository;

    private final companyImp companyService;


    public offreImp(offreRepository offerRepository, companyImp companyService) {
        this.offerRepository = offerRepository;
        this.companyService = companyService;
    }



    @Override
    public Offer addOffer(Offer offer) {
        // Ajoutez l'offre
        Offer addedOffer = this.offerRepository.save(offer);

        // Chargez l'entreprise complète associée à l'offre
        Entreprise entreprise = this.entrepriseRepository.findById(offer.getEntreprise().getId())
                .orElseThrow(() -> new EntityNotFoundException("Entreprise not found"));
        Category cat = this.catRepository.findById(offer.getCategory().getId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        // Mettez à jour l'offre avec l'entreprise complète
        addedOffer.setEntreprise(entreprise);
        addedOffer.setCategory(cat);

        return addedOffer;
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return null;
    }

    @Override
    public List<Offer> getOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer getById(Long id) {
        return null;
    }

    @Override
    public Set<Offer> getOffersOfCompany(Entreprise entreprise) {
        return new HashSet<>(this.offerRepository.findByEntreprise(entreprise));
    }

    @Override
    public void deleteOffer(Integer id) {
        this.offerRepository.deleteById(id);
    }

}



