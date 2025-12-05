package com.wellnest.demo.controller;

import com.wellnest.demo.model.Cardio;
import com.wellnest.demo.service.CardioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/cardio")
@CrossOrigin(origins = "*")
public class CardioController {

    private final CardioService cardioService;

    public CardioController(CardioService cardioService) {
        this.cardioService = cardioService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCardio(@RequestBody Cardio cardio) {
        return ResponseEntity.ok(cardioService.saveCardio(cardio));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cardio>> getCardio(@RequestParam String email) {
        return ResponseEntity.ok(cardioService.getCardio(email));
    }
}
