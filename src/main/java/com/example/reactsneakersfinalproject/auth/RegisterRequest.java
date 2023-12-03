package com.example.reactsneakersfinalproject.auth;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private  String email;
    private String phone;
    private  String password;
}
