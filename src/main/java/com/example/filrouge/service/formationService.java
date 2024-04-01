package com.example.filrouge.service;

import com.example.filrouge.model.Formation;

import java.util.List;
import java.util.Optional;

public interface formationService {

    public Formation addFormation(Formation formation);

    public Formation updateFormation(Formation formation);

    public List<Formation> getAll();

    public void deleteFormation(Long id);

    public Formation findById(Long id);

    public Optional<Formation> findByTitle(String title);
}
