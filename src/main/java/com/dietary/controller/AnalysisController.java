package com.dietary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dietary.entity.NutrientAnalysis;
import com.dietary.service.AnalysisService;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin
public class AnalysisController {

    @Autowired
    private AnalysisService service;

    @GetMapping("/{userId}")
    public NutrientAnalysis analyze(@PathVariable Long userId) {
        return service.analyze(userId);
    }
}