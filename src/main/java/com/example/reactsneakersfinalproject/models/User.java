package com.example.reactsneakersfinalproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
    private List<Cart> carts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
    private List<Favorite> favorites;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
    private List<Shipping> shippings;

}
