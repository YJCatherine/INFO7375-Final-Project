package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {

    private Map<String, String> recipes = new HashMap<>();

    public RecipeService() {
        recipes.put("I am looking for a hearty vegan dinner option for tonight. What do you recommend?", "Tofu Stir-Fry with Vegetables: Ingredients: 200g firm tofu, cubed, 2 tablespoons olive oil, 1 cup broccoli florets, 1 bell pepper sliced, 1 carrot julienned, 2 tablespoons soy sauce, 2 cloves garlic, minced, 1 tablespoon grated ginger, 1 teaspoon sesame seeds. Instructions: Press tofu, cube, sauté garlic and ginger, add vegetables, add tofu and soy sauce, cook, garnish with sesame seeds.");
        recipes.put("I have a nut allergy and I'm looking for a healthy lunch option that doesn't include any nuts. Can you help?", "Grilled Chicken Salad: Ingredients: 200g chicken breast, grilled and sliced, 2 cups mixed greens, 1/2 cup halved cherry tomatoes, 1/2 sliced cucumber, 2 tablespoons olive oil, 1 tablespoon lemon juice, salt, and pepper. Instructions: Grill and slice chicken, mix salad ingredients, whisk dressing, combine, top with chicken, serve.");
        recipes.put("It's getting cold outside, and I'm looking for a warm and comforting dinner recipe. What do you suggest?", "Beef and Vegetable Stew: Ingredients: 500g beef chunks, 2 cubed potatoes, 2 sliced carrots, 1 chopped onion, 4 cups beef broth, 1 tablespoon tomato paste, 1 teaspoon dried thyme, salt, and pepper. Instructions: Brown beef, sauté onions, add potatoes and carrots, add broth and tomato paste, season, simmer, serve.");
    }

    public String getRecipeAnswer(String question) {
        return recipes.getOrDefault(question, "Sorry, I couldn't find an answer to your question.");
    }
}

