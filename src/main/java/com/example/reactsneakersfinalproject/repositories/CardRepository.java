package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Modifying
    @Query("UPDATE Card c SET c.title = :title, c.price = :price, c.imageURL = :imageURL, c.count = :count, c.totalPrice = :totalPrice, c.parent_id = :parent_id WHERE c.id = :id")
    void updateCard(@Param("id") int id,
                    @Param("title") String title,
                    @Param("price") int price,
                    @Param("imageURL") String imageURL,
                    @Param("count") int count,
                    @Param("totalPrice") int totalPrice,
                    @Param("parent_id") int parent_id);

    @Modifying
    @Query("UPDATE Card c SET c.last_id = :last_id WHERE c.id = :id")
    void updateLastIdCard(@Param("id") int id, @Param("last_id") int last_id);

    @Query("FROM Card c WHERE c.id = :id")
    Card findCardById(@Param("id") int id);

}
