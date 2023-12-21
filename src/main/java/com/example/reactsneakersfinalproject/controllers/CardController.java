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
    public void updateCard(@RequestParam Integer id,
                           @RequestParam String title,
                           @RequestParam Integer price,
                           @RequestParam String imageURL,
                           @RequestParam Integer count,
                           @RequestParam Integer totalPrice,
                           @RequestParam Integer parent_id) {
        cardService.updateCard(id, title, price, imageURL,
                count, totalPrice, parent_id);
    }
    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable Integer id) {
        cardService.deleteCardById(id);
    }

    @GetMapping("/{id}")
    public Card findCardById(@PathVariable Integer id) {
        return cardService.findCardById(id);
    }

}

