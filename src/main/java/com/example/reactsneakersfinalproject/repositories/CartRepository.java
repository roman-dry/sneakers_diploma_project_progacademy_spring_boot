package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("FROM Cart c WHERE c.user_id = :user_id")
    List<Cart> getCartsByUserId(@Param("user_id") Integer user_id);

    @Modifying
    @Query("UPDATE Cart c SET c.count = :count, c.totalPrice = :totalprice " +
            "WHERE c.parent_id = :parent_id AND c.user_id = :user_id")
    void updateCartById(@Param("count") Integer count,
                        @Param("totalprice") Integer totalprice,
                        @Param("parent_id") Integer parent_id,
                        @Param("user_id") Integer user_id);
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.user_id = :user_id")
    void deleteCartByUserId(@Param("user_id") Integer user_id);

    @Modifying
    @Query("DELETE FROM Cart c WHERE c.user_id = :user_id and c.parent_id = :parent_id")
    void deleteByParentId(@Param("user_id") Integer user_id, @Param("parent_id") Integer parent_id);

}
