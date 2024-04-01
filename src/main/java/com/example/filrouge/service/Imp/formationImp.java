package com.example.filrouge.service.Imp;

import java.util.List;
import java.util.Optional;

import com.example.filrouge.model.Formation;
import com.example.filrouge.repository.formationRepository;
import com.example.filrouge.service.formationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class formationImp implements formationService {

    @Autowired
    private formationRepository forRepository;

    @Override
    public Formation addFormation(Formation formation) {

        System.out.println("save training");
		/*Formation training = new Formation();
		training.setTitle(formation.getTitle());
		training.setDescription(formation.getDescription());
		training.setAddress(formation.getAddress());
		training.setDate(formation.getDate());
		training.setDuration(formation.getDuration());
		training.setPhone(formation.getPhone());
		training.setFileName(formation.getFileName());
		training.setEntreprise(formation.getEntreprise()); */

        return this.forRepository.save(formation);
    }



    @Override
    public List<Formation> getAll() {
        System.out.println("get all data");
        return this.forRepository.findAll();
    }

    @Override
    public void deleteFormation(Long id) {

        this.forRepository.deleteById(id);
    }

    @Override
    public Formation findById(Long id) {

        return this.forRepository.findById(id).get();
    }

    @Override
    public Optional<Formation> findByTitle(String title) {

        return this.forRepository.findByTitle(title);
    }

    @Override
    public Formation updateFormation(Formation formation) {
        return this.forRepository.save(formation);
    }

}
