package com.example.reactsneakersfinalproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parent_id;
    private String title;
    private int price;
    @Column(name = "imageurl")
    private String imageURL;
    private int count;
    @Column(name = "totalprice")
    private int totalPrice;
    private int last_id;
}
