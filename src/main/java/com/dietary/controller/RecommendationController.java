package com.dietary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dietary.service.RecommendationService;

@RestController
@RequestMapping("/api/recommend")
@CrossOrigin
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @GetMapping("/{deficiency}")
    public String getSuggestion(@PathVariable String deficiency) {
        return service.getSuggestion(deficiency);
    }
}