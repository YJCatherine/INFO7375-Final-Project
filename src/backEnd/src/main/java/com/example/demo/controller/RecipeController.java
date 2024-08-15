package com.example.demo.controller;

import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/ask")
    public ResponseEntity<String> getRecipeAnswer(@RequestBody String question) {
        String answer = recipeService.getRecipeAnswer(question);
        return ResponseEntity.ok(answer);
    }
}

