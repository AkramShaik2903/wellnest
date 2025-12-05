package com.wellnest.demo.service;

import com.wellnest.demo.model.Cardio;
import com.wellnest.demo.repository.CardioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardioService {

    private final CardioRepository cardioRepository;

    public CardioService(CardioRepository cardioRepository) {
        this.cardioRepository = cardioRepository;
    }

    public Cardio saveCardio(Cardio cardio) {
        cardio.setCreatedAt(LocalDateTime.now());
        return cardioRepository.save(cardio);
    }

    public List<Cardio> getCardio(String email) {
        return cardioRepository.findByEmailOrderByCreatedAtDesc(email);
    }
}
