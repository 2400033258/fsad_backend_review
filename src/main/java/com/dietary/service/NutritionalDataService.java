package com.dietary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dietary.entity.NutritionalData;
import com.dietary.repository.NutritionalDataRepository;

@Service
public class NutritionalDataService {

    @Autowired
    private NutritionalDataRepository repo;

    // ➕ Add new food nutritional data
    public NutritionalData save(NutritionalData data) {
        return repo.save(data);
    }

    // 📋 Get all nutritional data
    public List<NutritionalData> getAll() {
        return repo.findAll();
    }

    // 🔍 Get by food name
    public Optional<NutritionalData> getByFoodName(String foodName) {
        return repo.findByFoodName(foodName);
    }

    // ❌ Delete by id
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // 🔄 Update (same as save)
    public NutritionalData update(NutritionalData data) {
        return repo.save(data);
    }
}