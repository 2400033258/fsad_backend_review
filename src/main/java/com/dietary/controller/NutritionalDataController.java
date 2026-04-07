package com.dietary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dietary.entity.NutritionalData;
import com.dietary.service.NutritionalDataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nutrition")
@CrossOrigin
public class NutritionalDataController {

    @Autowired
    private NutritionalDataService service;

    @PostMapping
    public NutritionalData add(@RequestBody NutritionalData data) {
        return service.save(data);
    }

    @GetMapping
    public List<NutritionalData> getAll() {
        return service.getAll();
    }

    @GetMapping("/{foodName}")
    public Optional<NutritionalData> getByFood(@PathVariable String foodName) {
        return service.getByFoodName(foodName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}