package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Card;
import com.example.reactsneakersfinalproject.repositories.CardRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    @Transactional(readOnly = true)
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }
    @Transactional
    public void updateCard(Integer id, String title, Integer price, String imageURL,
                           Integer count, Integer totalPrice, Integer parent_id) {

        cardRepository.updateCard(id, title, price, imageURL, count, totalPrice, parent_id);

    }
    @Transactional
    public void deleteCardById(Integer id) {
        cardRepository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Card findCardById(Integer id) {
        return cardRepository.findCardById(id);
    }

}
