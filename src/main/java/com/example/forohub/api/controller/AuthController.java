package com.example.forohub.api.controller;

import com.example.forohub.api.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/foro")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String correoElectronico = credentials.get("correoElectronico");
            String contrasena = credentials.get("contrasena");

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(correoElectronico, contrasena);
            Authentication authentication = authenticationManager.authenticate(authToken);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = tokenService.generateToken(userDetails);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}
