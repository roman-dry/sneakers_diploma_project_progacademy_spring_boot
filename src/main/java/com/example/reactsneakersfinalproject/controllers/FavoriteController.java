package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.models.Favorite;
import com.example.reactsneakersfinalproject.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/favorite")
    public Favorite saveFavorite(@RequestBody Favorite favorite) {
        return favoriteService.save(favorite);
    }

    @DeleteMapping("/favorite/{id}")
    public void deleteFavoriteById(@PathVariable("id") Integer id) {
        favoriteService.deleteFavoriteById(id);
    }

    @GetMapping("/favorite")
    public List<Favorite> getFavoriteByUserId(@RequestParam Integer user_id) {
        return favoriteService.getFavoriteByUserId(user_id);
    }
}