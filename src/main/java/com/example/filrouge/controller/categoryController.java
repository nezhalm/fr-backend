package com.example.filrouge.controller;
import com.example.filrouge.model.Category;
import com.example.filrouge.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class categoryController {

    @Autowired
    private categoryService catService;



    @PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {

        Category cat = catService.addCategory(category);

        return ResponseEntity.ok(cat);
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {

        return catService.updateCategory(category);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCategories(){

        return ResponseEntity.ok(catService.getCategories());
    }

    @GetMapping("/{catId}")
    public Category getCategoryById(@PathVariable("catId") Long id) {

        return this.catService.getCategoryById(id);
    }

    @DeleteMapping("/{catId}")
    public void deleteCategory(@PathVariable("catId") Long id) {

        this.catService.deleteCategory(id);
    }
}
