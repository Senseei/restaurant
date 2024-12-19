package com.senseei.restaurant.dtos;

public class AuthCredentialsDTO {
    private final String username;
    private final String password;

    public AuthCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
