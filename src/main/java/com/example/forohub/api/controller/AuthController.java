package com.example.forohub.api.controller;

import com.example.forohub.api.model.Usuario;
import com.example.forohub.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario loginRequest) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    loginRequest.getCorreoElectronico(), loginRequest.getContrasena());

            Authentication authentication = authenticationManager.authenticate(authToken);

            return tokenService.generateToken(authentication);
        } catch (AuthenticationException e) {
            return "Error: " + e.getMessage();
        }
    }
}
