package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
