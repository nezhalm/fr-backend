package com.example.filrouge.service;

import com.example.filrouge.dtos.request.LoginRequest;
import com.example.filrouge.dtos.request.RegisterRequest;
import com.example.filrouge.dtos.response.AuthResponse;

public interface authService {

   AuthResponse login(LoginRequest loginRequest);
   AuthResponse register(RegisterRequest registerRequest);

}