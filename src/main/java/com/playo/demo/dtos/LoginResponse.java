package com.playo.demo.dtos;

public class LoginResponse {
    private Long userId;
    private String username;
    private String jwtToken;

    public LoginResponse(Long userId, String username, String jwtToken) {
        this.userId = userId;
        this.username = username;
        this.jwtToken = jwtToken;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
