package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Favorite;
import com.example.reactsneakersfinalproject.repositories.FavoriteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Data
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Favorite save(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void deleteFavoriteById(int id) {
        favoriteRepository.deleteById(id);
    }

    public List<Favorite> getFavoriteByUserId(int user_id) {
        return favoriteRepository.getFavoritesByUserId(user_id);
    }

}
