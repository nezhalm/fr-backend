package com.example.filrouge.controller;
import com.example.filrouge.dtos.request.offreRequest;
import com.example.filrouge.model.Entreprise;
import com.example.filrouge.model.Offer;
import com.example.filrouge.service.companyService;
import com.example.filrouge.service.offreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offers")
public class offreController {

    private final offreService offerService;
    private final companyService compService;

    public offreController(offreService offerService, companyService compService) {
        this.offerService = offerService;
        this.compService = compService;
    }

    @PostMapping("/add")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
        Offer addedOffer = offerService.addOffer(offer);
        return new ResponseEntity<>(addedOffer, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(){

        return ResponseEntity.ok(this.offerService.getOffers());
    }
    @GetMapping("/company/{CompanyId}")
    public ResponseEntity<?> getOffersOfCompany(@PathVariable("CompanyId") Long id) {
        //first method
        Entreprise entreprise = this.compService.findById(id);
        Set<Offer> offers = entreprise.getOffers();
        List<Offer> list = new ArrayList<>(offers);
        //return ResponseEntity.ok(list);
        //second method
        Entreprise entreprise2 = new Entreprise();
        entreprise2.setId(id);
        Set<Offer> offersCompany = this.offerService.getOffersOfCompany(entreprise2);

        return ResponseEntity.ok(offersCompany);
    }
    @DeleteMapping("/{offerId}")
    public void deleteOffer(@PathVariable("offerId") Integer id) {
        this.offerService.deleteOffer(id);
    }
}
