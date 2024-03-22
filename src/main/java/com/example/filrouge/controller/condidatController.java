package com.example.filrouge.controller;
import com.example.filrouge.model.Candidat;
import com.example.filrouge.model.Response;
import com.example.filrouge.service.candidateService;
import com.example.filrouge.service.companyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/candidat")
public class condidatController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final companyService cService;
    private final candidateService candidatService;


    @Autowired  ServletContext context;
    public condidatController(companyService cService, candidateService candidatService) {
        this.cService = cService;
        this.candidatService = candidatService;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> addCandidat(@RequestBody Candidat candidat) {
        Candidat savedCandidat = candidatService.addCandidat(candidat);

        if (savedCandidat != null) {
            return new ResponseEntity<>(new Response("Candidat saved successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Response("Candidat not saved"), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(this.candidatService.getCandidats());
    }

    @GetMapping("/{CandidatId}")
    public Candidat getById(@PathVariable("CandidatId") Integer id) {
        return this.candidatService.findById(id);
    }

    @DeleteMapping("/{CandidatId}")
    public void deleteCandidat(@PathVariable("CandidatId") Integer id) {
        this.candidatService.deleteCandidat(id);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Candidat> getCandidatByEmail(@PathVariable("email") String email) {
        Candidat candidat = candidatService.findByEmail(email);
        if (candidat != null) {
            return ResponseEntity.ok(candidat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
