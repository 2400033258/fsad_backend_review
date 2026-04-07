package com.dietary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dietary.entity.DietaryRecord;

public interface DietaryRecordRepository extends JpaRepository<DietaryRecord, Long> {
}