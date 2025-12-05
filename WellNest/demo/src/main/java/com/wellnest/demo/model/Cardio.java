package com.wellnest.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cardio")
public class Cardio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String activity;
    private int duration;
    private Double distance;
    private int calories;
    private LocalDateTime createdAt;

    public Cardio() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getActivity() { return activity; }
    public void setActivity(String activity) { this.activity = activity; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public Double getDistance() { return distance; }
    public void setDistance(Double distance) { this.distance = distance; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
