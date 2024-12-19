package com.senseei.restaurant.controllers;

import com.senseei.restaurant.dtos.AuthCredentialsDTO;
import com.senseei.restaurant.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthCredentialsDTO authCredentialsDTO) {
        return service.login(authCredentialsDTO);
    }
}
