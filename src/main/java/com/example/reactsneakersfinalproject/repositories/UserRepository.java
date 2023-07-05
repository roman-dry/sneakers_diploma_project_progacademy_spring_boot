package com.example.reactsneakersfinalproject.repositories;

import com.example.reactsneakersfinalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User u WHERE u.email = :email AND u.password = :password")
    User getUserByLoginAndPass(@Param("email") String email, @Param("password") String password);

    @Query("FROM User u WHERE u.email = :email")
    User getUserByPass(@Param("email") String email);

}
