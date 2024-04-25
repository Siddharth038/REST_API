package com.example.traini8.traini8.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.traini8.traini8.entity.TrainingCenter;
import com.example.traini8.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;

// Enable Cross-Origin Resource Sharing (CORS) for this controller
@CrossOrigin(origins = "http://localhost:8880")
@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    // Constructor injection of TrainingCenterService
    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    // HTTP GET request handler for fetching all training centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        // Retrieve all training centers from the service
        List<TrainingCenter> trainingCenters = service.getAllTrainingCenters();
        // Return a ResponseEntity with the list of training centers and HTTP status OK
        return ResponseEntity.ok(trainingCenters);
    }

    // HTTP POST request handler for creating a new training center
    @PostMapping("/create")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter center) {
        // Create the new training center using the provided data
        TrainingCenter savedCenter = service.createTrainingCenter(center);
        // Return a ResponseEntity with the created training center and HTTP status CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCenter);
    }
}
