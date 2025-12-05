package com.wellnest.demo.repository;

import com.wellnest.demo.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByEmailOrderByCreatedAtDesc(String email);
}
