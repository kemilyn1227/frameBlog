package com.descomplica.frameBlog.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.descomplica.frameBlog.request.AuthRequest;

public interface AuthenticationService extends UserDetailsService{

    String getToken(AuthRequest auth);
    String validateJwtToken(String token);

}
