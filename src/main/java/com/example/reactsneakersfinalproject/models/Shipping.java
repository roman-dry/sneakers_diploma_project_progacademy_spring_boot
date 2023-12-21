package com.example.reactsneakersfinalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shipping")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    private String country;
    private String city;
    private String address;
    private String fullname;
    private String phone;
    private String size;
    private double total_sum;
    @Column(name = "total_desc")
    private  String totalDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    @JsonIgnore
    private User user;
}
