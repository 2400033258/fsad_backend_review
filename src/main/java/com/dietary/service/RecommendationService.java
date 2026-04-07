package com.dietary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dietary.repository.RecommendationRepository;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository repo;

    public String getSuggestion(String deficiency) {
        return repo.findByDeficiency(deficiency)
                .map(r -> r.getSuggestion())
                .orElse("Maintain balanced diet");
    }
}