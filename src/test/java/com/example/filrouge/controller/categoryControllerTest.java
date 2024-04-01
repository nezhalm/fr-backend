package com.example.filrouge.controller;

import com.example.filrouge.model.Category;
import com.example.filrouge.service.Imp.categoryImp;
import com.example.filrouge.service.categoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class categoryControllerTest {

    @Mock
    private categoryImp catService;

    @InjectMocks
    private categoryController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateCategory() {
        // Créer un objet Category pour simuler la requête
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Updated Category");
        category.setDescription("Updated Category");
        category.setOffers(null); // Correction de setTitle() à setName()


        // Définir le comportement attendu du service
        when(catService.updateCategory(any(Category.class))).thenReturn(category);

        // Appeler la méthode du contrôleur à tester
        Category updatedCategory = controller.updateCategory(category);

        // Vérifier que la catégorie retournée est celle renvoyée par le service
        assertEquals(category, updatedCategory);
    }



    @Test
    void testGetCategoryById() {
        // Créer un objet Category fictif
        Category category = new Category("title", "Category");

        // Définir le comportement attendu du service
        when(catService.getCategoryById(1L)).thenReturn(category);

        // Appeler la méthode du contrôleur à tester
        Category retrievedCategory = controller.getCategoryById(1L);

        // Vérifier que la catégorie retournée est celle renvoyée par le service
        assertEquals(category, retrievedCategory);
    }

    @Test
    void testDeleteCategory() {
        // Appeler la méthode du contrôleur à tester
        controller.deleteCategory(1L);

        // Vérifier que la méthode de suppression du service a été appelée avec le bon ID
        verify(catService).deleteCategory(1L);
    }

    @Test
    void testCreateCategory() {
        // Créer un objet Category pour simuler la requête
        Category category = new Category();
        category.setTitle( "Test Category");

        // Définir le comportement attendu du service
        when(catService.addCategory(any(Category.class))).thenReturn(category);

        // Appeler la méthode du contrôleur à tester
        ResponseEntity<Category> responseEntity = controller.createCategory(category);

        // Vérifier le code de statut HTTP retourné
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Vérifier que le corps de la réponse contient la catégorie ajoutée
        assertEquals(category, responseEntity.getBody());
    }


    @Test
    public void testGetCategories() {
        when(catService.getCategories()).thenReturn(Collections.singletonList(new Category()));
        ResponseEntity<?> response = controller.getCategories();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}
