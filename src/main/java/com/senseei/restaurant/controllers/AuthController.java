package com.senseei.restaurant.controllers;

import com.senseei.restaurant.dtos.AuthCredentialsDTO;
import com.senseei.restaurant.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialsDTO authCredentialsDTO) {
        return ResponseEntity.ok(Map.of("access-token", service.login(authCredentialsDTO)));
    }
}
