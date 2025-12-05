package com.wellnest.demo.repository;

import com.wellnest.demo.model.Cardio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardioRepository extends JpaRepository<Cardio, Long> {
    List<Cardio> findByEmailOrderByCreatedAtDesc(String email);
}
