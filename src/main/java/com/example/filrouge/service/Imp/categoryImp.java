package com.example.filrouge.service.Imp;
import com.example.filrouge.helper.InvalidEntityException;
import com.example.filrouge.model.Category;
import com.example.filrouge.repository.categoryRepository;
import com.example.filrouge.service.categoryService;
import com.example.filrouge.validator.CategoryValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categoryImp implements categoryService {

    @Autowired
    private categoryRepository catRepository;

    @Override
    public Category addCategory(Category category) {
        List<String> errors = CategoryValidator.validate(category);
        if(!errors.isEmpty()) {
            System.out.println("La category n'est pas valide");
            throw new InvalidEntityException("La category n'est pas valide", errors);
        }

        return this.catRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {

        List<String> errors = CategoryValidator.validate(category);
        if(!errors.isEmpty()) {
            System.out.println("La category n'est pas valide");
            throw new InvalidEntityException("La category n'est pas valide", errors);
        }

        return this.catRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {

        return this.catRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {

        this.catRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(Long id) {

        return this.catRepository.findById(id).get();
    }
}
