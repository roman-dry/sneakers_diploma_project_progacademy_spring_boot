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
    private Integer id;
    private Integer parent_id;
    private String title;
    private Integer price;
    @Column(name = "imageurl")
    private String imageURL;
    private Integer count;
    @Column(name = "totalprice")
    private Integer totalPrice;
}
