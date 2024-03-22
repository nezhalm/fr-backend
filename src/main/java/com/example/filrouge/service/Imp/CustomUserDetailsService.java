package com.example.filrouge.service.Imp;

import com.example.filrouge.repository.userRepository;
import com.example.filrouge.security.authenticators.UserAuthenticator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final userRepository userR;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userR.findUserByEmail(username);

        return user.map(UserAuthenticator::new)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found "+username));
    }
}
