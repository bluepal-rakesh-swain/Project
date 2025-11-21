 package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.config.JwtProvider;
import com.nt.dto.AuthResponse;
import com.nt.dto.LoginRequest;
import com.nt.entity.User;
import com.nt.repository.UserRepository;
import com.nt.service.AuthService;
import com.nt.service.CustomUserServiceImplementation;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthService authService;
	// @Autowired
	   // private AuthServices authServices;
		@Autowired
		private UserRepository userRepository;
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    @Autowired
	    private CustomUserServiceImplementation customUserServiceImplementation;
	  

	
	@PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody User user) {
        User registeredUser = authService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
	    try {
	        AuthResponse response = authService.login(loginRequest);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (BadCredentialsException ex) {
	        throw ex; // let GlobalExceptionHandler catch it
	    }
	}

    
//    @PostMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) throws MessagingException {
//        String result = authServices.forgotPassword(request.getEmail());
//        return ResponseEntity.ok(result);
//    }
//    
    
//    @PostMapping("/reset-password")
//    public ResponseEntity<String> resetPassword(@RequestBody ResetRequest request) {
//        String email = request.getEmail();
//        String otp = request.getOtp();
//        String newPassword = request.getNewPassword();
//
//        // ✅ Find the OTP in the DB
//        PasswordResetToken resetToken = tokenRepository.findByToken(otp).orElse(null);
//
//        if (resetToken == null || resetToken.getUser() == null) {
//            return ResponseEntity.badRequest().body("Invalid OTP.");
//        }
//
//        // ✅ Match the OTP with correct email
//        if (!resetToken.getUser().getEmail().equals(email)) {
//            return ResponseEntity.badRequest().body("OTP does not match this email.");
//        }
//
//        // ✅ Check expiry
//        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
//            return ResponseEntity.badRequest().body("OTP has expired.");
//        }
//
//        // ✅ Reset password
//        User user = resetToken.getUser();
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userRepository.save(user);
//
//        // ✅ Invalidate used token
//        tokenRepository.delete(resetToken);
//
//        return ResponseEntity.ok("✅ Password reset successfully! Please go to login page");
//    }
   }


 
 

 
 
 
 
 
 
