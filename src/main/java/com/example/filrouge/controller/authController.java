package com.example.filrouge.controller;
import com.example.filrouge.dtos.request.LoginRequest;
import com.example.filrouge.dtos.request.RegisterRequest;
import com.example.filrouge.dtos.response.AuthResponse;
import com.example.filrouge.service.authService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class authController {

    private final authService userAuthService;

    @RequestMapping ("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userAuthService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userAuthService.register(registerRequest), HttpStatus.OK);
    }

}