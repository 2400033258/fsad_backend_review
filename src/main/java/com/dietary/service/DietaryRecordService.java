package com.dietary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dietary.entity.DietaryRecord;
import com.dietary.repository.DietaryRecordRepository;
import java.util.List;

@Service
public class DietaryRecordService {

    @Autowired
    private DietaryRecordRepository repo;

    public DietaryRecord save(DietaryRecord r) {
        return repo.save(r);
    }

    public List<DietaryRecord> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}