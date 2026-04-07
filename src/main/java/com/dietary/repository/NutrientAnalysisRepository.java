package com.dietary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dietary.entity.NutrientAnalysis;

public interface NutrientAnalysisRepository extends JpaRepository<NutrientAnalysis, Long> {
}