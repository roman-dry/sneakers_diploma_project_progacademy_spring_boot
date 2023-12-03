package com.example.reactsneakersfinalproject.auth;

import com.example.reactsneakersfinalproject.models.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;
    private Integer userId;
    private Role role;
}
