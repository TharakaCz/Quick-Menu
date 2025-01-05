package com.backend.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.api.dto.AuthDTO;
import com.backend.api.dto.UserDTO;
import com.backend.api.model.User;
import com.backend.api.repository.UserRepository;
import com.backend.api.service.AuthService;
import com.backend.api.util.JwtUtil;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    public AuthDTO login(UserDTO userDTO) throws Exception {
        if (userDTO.getEmail() == null || userDTO.getPassword() == null) {
            throw new IllegalArgumentException("Email and password cannot be null");
        }

        User user = this.userRepository.findByEmail(userDTO.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + userDTO.getEmail());
        }
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = this.jwtUtil.generateToken(authentication);

        return new AuthDTO(user.getName(), token);
    }


}
