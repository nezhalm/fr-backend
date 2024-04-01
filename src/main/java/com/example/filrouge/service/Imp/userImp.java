package com.example.filrouge.service.Imp;
import com.example.filrouge.dtos.request.LoginRequest;
import com.example.filrouge.dtos.request.RegisterRequest;
import com.example.filrouge.dtos.response.AuthResponse;
import com.example.filrouge.dtos.response.UserResponse;
import com.example.filrouge.enums.Role;
import com.example.filrouge.model.User;
import com.example.filrouge.repository.userRepository;
import com.example.filrouge.security.JwtService;
import com.example.filrouge.security.authenticators.UserAuthenticator;
import com.example.filrouge.service.authService;
import jakarta.persistence.NonUniqueResultException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class userImp implements authService {

    private final userRepository uRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        User user = uRepository.findUserByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password incorrect"));

        UserAuthenticator userAuthenticator = new UserAuthenticator(user);
        String jwtToken = jwtService.generateToken(userAuthenticator);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUser(user);
        authResponse.setToken(jwtToken);
        return authResponse;
    }
    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        return null;
    }

    private boolean isEmailUnique(String email) {
        // Vérifie si l'e-mail est unique dans la base de données
        return uRepository.countByEmail(email) == 1;
    }


}
