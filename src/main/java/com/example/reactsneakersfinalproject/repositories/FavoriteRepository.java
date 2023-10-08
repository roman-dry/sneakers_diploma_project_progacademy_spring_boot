package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    @Query("FROM Favorite f WHERE f.user_id = :user_id")
    List<Favorite> getFavoritesByUserId(@Param("user_id") int user_id);

    @Modifying
    @Query("DELETE FROM Favorite f WHERE f.parent_id = :parent_id")
    void deleteFavoriteByParentId(@Param("parent_id") int parent_id);
}
