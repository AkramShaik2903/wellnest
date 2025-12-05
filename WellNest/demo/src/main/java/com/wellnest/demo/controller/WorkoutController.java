package com.wellnest.demo.controller;

import com.wellnest.demo.model.Workout;
import com.wellnest.demo.service.WorkoutService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/workout")
@CrossOrigin(origins = "*")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveWorkout(@RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.saveWorkout(workout));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Workout>> getWorkouts(@RequestParam String email) {
        return ResponseEntity.ok(workoutService.getWorkouts(email));
    }
}
