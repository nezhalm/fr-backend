package com.example.filrouge.service;

import com.example.filrouge.dtos.request.LoginRequest;
import com.example.filrouge.dtos.request.RegisterRequest;
import com.example.filrouge.dtos.response.AuthResponse;
import com.example.filrouge.model.User;

import java.util.List;

public interface authService {

   AuthResponse login(LoginRequest loginRequest);
   AuthResponse register(RegisterRequest registerRequest);

}