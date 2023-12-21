package com.example.reactsneakersfinalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer price;
    @Column(name = "imageurl")
    private String imageURL;
    private Integer count;
    @Column(name = "totalprice")
    private Integer totalPrice;
    private Integer parent_id;
    private Integer user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    @JsonIgnore
    private User user;
}
