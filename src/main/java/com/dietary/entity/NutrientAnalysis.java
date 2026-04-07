package com.dietary.entity;

import jakarta.persistence.*;

@Entity
public class NutrientAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int totalCalories;
    private int totalProtein;
    private int totalCarbs;
    private int totalFat;
    private String deficiency;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public int getTotalCalories() { return totalCalories; }
    public void setTotalCalories(int totalCalories) { this.totalCalories = totalCalories; }

    public int getTotalProtein() { return totalProtein; }
    public void setTotalProtein(int totalProtein) { this.totalProtein = totalProtein; }

    public int getTotalCarbs() { return totalCarbs; }
    public void setTotalCarbs(int totalCarbs) { this.totalCarbs = totalCarbs; }

    public int getTotalFat() { return totalFat; }
    public void setTotalFat(int totalFat) { this.totalFat = totalFat; }

    public String getDeficiency() { return deficiency; }
    public void setDeficiency(String deficiency) { this.deficiency = deficiency; }
}