package com.dietary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dietary.entity.Recommendation;
import java.util.Optional;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    Optional<Recommendation> findByDeficiency(String deficiency);
}