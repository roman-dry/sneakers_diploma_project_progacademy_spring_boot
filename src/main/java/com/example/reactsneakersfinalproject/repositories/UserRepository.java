package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User u WHERE u.email = :email AND u.password = :password")
    User getUserByLoginAndPass(@Param("email") String email, @Param("password") String password);


    @Query("FROM User u WHERE u.email = :email")
    User getUserByPass(@Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.name = :name, u.email = :email, u.phone = :phone, u.password = :password WHERE u.id = :id")
    void updateUser(@Param("id") int id, @Param("name") String name,
                    @Param("email") String email, @Param("phone") String phone,
                    @Param("password") String password);

}
