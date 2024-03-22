package com.example.filrouge.service;

import com.example.filrouge.model.Entreprise;

import java.util.List;

public interface companyService {
    List<Entreprise> getAllCompanies();
    public Entreprise findById(Long id);
    public Entreprise findByName(String name);

}
