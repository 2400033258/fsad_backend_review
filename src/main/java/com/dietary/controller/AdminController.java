package com.dietary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dietary.entity.NutritionalData;
import com.dietary.entity.User;
import com.dietary.repository.UserRepository;
import com.dietary.service.NutritionalDataService;
import com.dietary.service.RecommendationService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private NutritionalDataService nutritionService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RecommendationService recommendationService;

    // 🔐 CHECK ADMIN
    private boolean isAdmin(String role) {
        return role != null && role.equalsIgnoreCase("ADMIN");
    }

    // 👑 ADD NUTRITION
    @PostMapping("/nutrition")
    public ResponseEntity<?> addNutrition(
            @RequestHeader("role") String role,
            @RequestBody NutritionalData data) {

        if (!isAdmin(role)) {
            return ResponseEntity.status(403).body("Access denied");
        }

        return ResponseEntity.ok(nutritionService.save(data));
    }

    // 👑 DELETE NUTRITION
    @DeleteMapping("/nutrition/{id}")
    public ResponseEntity<?> deleteNutrition(
            @RequestHeader("role") String role,
            @PathVariable Long id) {

        if (!isAdmin(role)) {
            return ResponseEntity.status(403).body("Access denied");
        }

        nutritionService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // 👑 VIEW ALL USERS
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(
            @RequestHeader("role") String role) {

        if (!isAdmin(role)) {
            return ResponseEntity.status(403).body("Access denied");
        }

        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }

    // 👑 GET RECOMMENDATION
    @GetMapping("/recommend/{deficiency}")
    public ResponseEntity<?> getRecommendation(
            @RequestHeader("role") String role,
            @PathVariable String deficiency) {

        if (!isAdmin(role)) {
            return ResponseEntity.status(403).body("Access denied");
        }

        String suggestion = recommendationService.getSuggestion(deficiency);
        return ResponseEntity.ok(suggestion);
    }
}