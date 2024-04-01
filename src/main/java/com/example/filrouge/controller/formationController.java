package com.example.filrouge.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;


import com.example.filrouge.model.Formation;
import com.example.filrouge.model.Offer;
import com.example.filrouge.model.Response;
import com.example.filrouge.service.formationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api/formation")
@CrossOrigin("*")
public class formationController {

    @Autowired
    private formationService forService;

    @Autowired
    ServletContext context;

    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(this.forService.getAll());
    }


    @PostMapping("/save")
    public ResponseEntity<Formation> createTraining(@RequestBody Formation formation) {
            // Ajouter la formation
            Formation training = forService.addFormation(formation);
        return new ResponseEntity<>(training, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public Formation updateFormation(@RequestBody Formation formation) {

        return this.forService.updateFormation(formation);
    }

    @GetMapping("/{formationId}")
    public Formation findById(@PathVariable("formationId") Long id) {

        return this.forService.findById(id);
    }

    @DeleteMapping("/{formationId}")
    public void deleteFormation(@PathVariable("formationId") Long id) {

        this.forService.deleteFormation(id);
    }

}
