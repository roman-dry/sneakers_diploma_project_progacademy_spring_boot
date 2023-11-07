package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.models.Card;
import com.example.reactsneakersfinalproject.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> findAll() {
        return cardService.findAll();
    }

    @PostMapping
    public Card saveCard(@RequestBody Card card) {
        return cardService.save(card);
    }

    @PatchMapping
    public void updateCard(@RequestParam int id,
                           @RequestParam String title,
                           @RequestParam int price,
                           @RequestParam String imageURL,
                           @RequestParam int count,
                           @RequestParam int totalPrice,
                           @RequestParam int parent_id) {
        cardService.updateCard(id, title, price, imageURL,
                count, totalPrice, parent_id);
    }
    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable int id) {
        cardService.deleteCardById(id);
    }

    @GetMapping("/{id}")
    public Card findCardById(@PathVariable int id) {
        return cardService.findCardById(id);
    }

}

