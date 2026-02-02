package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
public class CockTailApplicationController {

    private static final String COCKTAIL_API = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

    @GetMapping("/random-cocktail")
    public String sayHi(){
        return "hi";
    };

    
}
