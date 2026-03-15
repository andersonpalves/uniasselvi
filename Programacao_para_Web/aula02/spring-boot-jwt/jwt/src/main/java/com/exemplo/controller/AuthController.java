package com.exemplo.controller;

import com.exemplo.model.LoginRequest;
import com.exemplo.security.JwtUtil;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername()) &&
                "123".equals(request.getPassword())) {

            return JwtUtil.generateToken(request.getUsername());
        }

        throw new RuntimeException("Usuário inválido");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Rota protegida!";
    }
}