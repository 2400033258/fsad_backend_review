package com.dietary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dietary.entity.NutritionalData;
import java.util.Optional;

public interface NutritionalDataRepository extends JpaRepository<NutritionalData, Long> {
    Optional<NutritionalData> findByFoodName(String foodName);
}
