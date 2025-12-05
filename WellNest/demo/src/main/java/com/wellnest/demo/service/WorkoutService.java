package com.wellnest.demo.service;

import com.wellnest.demo.model.Workout;
import com.wellnest.demo.repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout saveWorkout(Workout workout) {
        workout.setCreatedAt(LocalDateTime.now());
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkouts(String email) {
        return workoutRepository.findByEmailOrderByCreatedAtDesc(email);
    }
}
