package com.dietary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dietary.entity.DietaryRecord;
import com.dietary.service.DietaryRecordService;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
@CrossOrigin
public class DietaryRecordController {

    @Autowired
    private DietaryRecordService service;

    // ➕ ADD RECORD
    @PostMapping
    public ResponseEntity<?> add(@RequestBody DietaryRecord record) {
        return ResponseEntity.ok(service.save(record));
    }

    // 📋 GET ALL RECORDS
    @GetMapping
    public ResponseEntity<List<DietaryRecord>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ❌ DELETE RECORD
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
