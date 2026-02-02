package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
public class CockTailApplicationController {

    private static final String COCKTAIL_API = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

    @GetMapping("/random-cocktail")
    public Map<String, Object> getRandomCocktail() {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(COCKTAIL_API, Map.class);
        Map<String, Object> drink = ((List<Map<String, Object>>) response.get("drinks")).get(0);

        // Extract Relevant Fields
        Map<String, Object> cocktail = new HashMap<>();
        cocktail.put("image", drink.get("strDrinkThumb"));
        cocktail.put("name", drink.get("strDrink"));
        cocktail.put("category", drink.get("strCategory"));
        cocktail.put("instructions", drink.get("strInstructions"));
        cocktail.put("alcoholic", drink.get("strAlcoholic"));
        cocktail.put("category", drink.get("strCategory"));

        List<String> ingredients = new ArrayList<>();
        for (int i = 1; i <= 15; i++){
            Object ingredient = drink.get("strIngredient" + i);
            if(ingredient != null) ingredients.add(ingredient.toString());
        }

        cocktail.put("ingredients", ingredients);

        return cocktail;

    };

    
}
