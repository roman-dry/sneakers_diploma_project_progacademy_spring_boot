package com.example.reactsneakersfinalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "order_description")
    private String orderDescription;
    @Column(name = "total_sum")
    private Double totalSum;
    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    @JsonIgnore
    private User user;
}
