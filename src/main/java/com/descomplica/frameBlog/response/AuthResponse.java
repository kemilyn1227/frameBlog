package com.descomplica.frameBlog.response;

public class AuthResponse {
    final String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}