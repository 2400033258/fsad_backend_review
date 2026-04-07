package com.dietary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dietary.entity.DietaryRecord;
import com.dietary.entity.NutrientAnalysis;
import com.dietary.entity.NutritionalData;
import com.dietary.repository.DietaryRecordRepository;
import com.dietary.repository.NutritionalDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnalysisService {

    @Autowired
    private DietaryRecordRepository recordRepo;

    @Autowired
    private NutritionalDataRepository nutritionRepo;

    public NutrientAnalysis analyze(Long userId) {

        List<DietaryRecord> records = recordRepo.findAll();

        int calories = 0;
        int protein = 0;
        int carbs = 0;
        int fat = 0;

        for (DietaryRecord r : records) {

            if (!r.getUserId().equals(userId)) continue;

            Optional<NutritionalData> foodOpt = 
                    nutritionRepo.findByFoodName(r.getFoodName());

            if (foodOpt.isPresent()) {
                NutritionalData food = foodOpt.get();

                calories += food.getCalories() * r.getQuantity();
                protein += food.getProtein() * r.getQuantity();
                carbs += food.getCarbs() * r.getQuantity();
                fat += food.getFat() * r.getQuantity();
            }
        }

        String deficiency;

        if (protein < 50) deficiency = "Low Protein";
        else if (calories < 1800) deficiency = "Low Energy";
        else if (fat > 70) deficiency = "High Fat";
        else deficiency = "Balanced";

        NutrientAnalysis result = new NutrientAnalysis();

        result.setUserId(userId);
        result.setTotalCalories(calories);
        result.setTotalProtein(protein);
        result.setTotalCarbs(carbs);
        result.setTotalFat(fat);
        result.setDeficiency(deficiency);

        return result;
    }
}
