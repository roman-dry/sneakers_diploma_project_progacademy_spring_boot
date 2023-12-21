package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("FROM Order o WHERE o.user_id = :user_id AND o.status = 'inactive'")
    List<Order> getOrderByUserId(@Param("user_id") Integer user_id);

    @Modifying
    @Query("UPDATE Order o SET o.status = :status WHERE o.user_id = :user_id")
    void updateOrderByUserId(@Param("status") String status,
                        @Param("user_id") Integer user_id);
}
