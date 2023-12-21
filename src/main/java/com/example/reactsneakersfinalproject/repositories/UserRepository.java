package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.name = :name, u.phone = :phone, u.password = :password WHERE u.id = :id")
    void updateUser(@Param("id") Integer id, @Param("name") String name,
                    @Param("phone") String phone, @Param("password") String password);

}
