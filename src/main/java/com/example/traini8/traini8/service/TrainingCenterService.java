package com.example.traini8.traini8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.traini8.traini8.entity.TrainingCenter;
import com.example.traini8.traini8.repository.TrainingCenterRepository;
import java.util.List;

// Indicates that this class is a service component
@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repository;

    // Retrieves all training centers from the repository
    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }

    // Creates a new training center
    public TrainingCenter createTrainingCenter(TrainingCenter center) {
        // Set the creation timestamp to the current system time
        center.setCreatedOn(System.currentTimeMillis());
        // Save the training center in the repository and return the saved instance
        return repository.save(center);
    }
}
