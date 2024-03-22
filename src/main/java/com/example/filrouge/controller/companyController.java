package com.example.filrouge.controller;
import com.example.filrouge.model.Entreprise;
import com.example.filrouge.repository.companyRepository;
import com.example.filrouge.service.companyService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class companyController {
    private final companyService cService;
    private final companyRepository cRepo;
    public companyController(companyService cService, companyRepository cRepo) {
        this.cService = cService;
        this.cRepo = cRepo;
    }

    @GetMapping("/id/{companyId}")
    public Entreprise findById(@PathVariable("companyId") Long id) {
        return this.cService.findById(id);
    }
    @PostMapping("/")
    public Object create( @RequestParam("company") String company, @RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, Exception {
        Entreprise entreprise = new ObjectMapper().readValue(company, Entreprise.class);
        Entreprise entity = new Entreprise();
        entity.setName(entreprise.getName());
        entity.setDescription(entreprise.getDescription());
        entity.setAddress(entreprise.getAddress());
        if(file != null) {
            entity.setFileName(file.getOriginalFilename());
            entity.setType(file.getContentType());
            try {
                entity.setPicByte(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.cRepo.save(entity);
    }


    @GetMapping("/{companyName}")
    public Entreprise findByName(@PathVariable("companyName") String name) {
        return this.cService.findByName(name);
    }


    @GetMapping
    public List<Entreprise> getAllCompanies() {
        return cService.getAllCompanies();
    }
}
