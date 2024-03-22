package com.example.filrouge.service.Imp;
import com.example.filrouge.model.Entreprise;
import com.example.filrouge.repository.companyRepository;
import com.example.filrouge.service.companyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service


    public class companyImp implements companyService {

        private final companyRepository cRepository;

    public companyImp(companyRepository cRepository) {
        this.cRepository = cRepository;
    }
    @Override
    public Entreprise findById(Long id) {

        return this.cRepository.findById(id).get();
    }

    public Entreprise findByName(String name) {
        return this.cRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Le company avec le nom '" + name + "' n'existe pas."));
    }

    @Override
        public List<Entreprise> getAllCompanies() {
            return cRepository.findAll();
        }

    public Entreprise getCompanyById(long companyId) {
        return cRepository.findById(companyId).orElse(null);
    }


}


