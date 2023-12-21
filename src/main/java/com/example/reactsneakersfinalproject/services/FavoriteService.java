package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Favorite;
import com.example.reactsneakersfinalproject.repositories.FavoriteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    @Transactional
    public void deleteFavoriteById(Integer id) {
        favoriteRepository.deleteFavoriteByParentId(id);
    }
    @Transactional(readOnly = true)
    public List<Favorite> getFavoriteByUserId(Integer user_id) {
        return favoriteRepository.getFavoritesByUserId(user_id);
    }

}
