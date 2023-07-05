package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    @Query("FROM Shipping s WHERE s.user_id = :user_id")
    List<Shipping> getShippingsByUserId(@Param("user_id") int user_id);
}
