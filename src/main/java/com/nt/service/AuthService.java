package com.nt.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.config.JwtProvider;
import com.nt.dto.AuthResponse;
import com.nt.dto.LoginRequest;
import com.nt.entity.User;
import com.nt.exception.EmailAlreadyExistsException;
import com.nt.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomUserServiceImplementation customUserServiceImplementation;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public User register(User user) {
    	
    	User existingUser = userRepository.findByEmail(user.getEmail());
    	
    	if (existingUser != null) {
    	    throw new EmailAlreadyExistsException("Email is already used with another account");
    	}


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    

    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        String token = jwtProvider.generateToken(authentication);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        
        // Extract the first role (or default to USER)
        String role = authorities.stream()
                                 .map(GrantedAuthority::getAuthority)
                                 .findFirst()
                                 .orElse("USER");
        
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Login Success");
        authResponse.setStatus(true);
        authResponse.setRole(role);
     

        return authResponse;
        

    }


   

}


