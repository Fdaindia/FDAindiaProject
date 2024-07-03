package com.example.demo.services;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.card.security.JwtTokenUtil;
import com.example.demo.entity.FDAIndiaKendra;
import com.example.demo.repository.FDAIndiaKendraRepository;
import com.example.demo.response.UserRequest;
import com.example.demo.response.UserResponse;

@Service
public class FdaIndiaKendraService {

    @Autowired
    private FDAIndiaKendraRepository fdaIndiaKendraRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserResponse registerUser(FDAIndiaKendra user) {
        UserResponse response = new UserResponse();
        try {
            if (fdaIndiaKendraRepository.findByUsername(user.getUsername()) != null) {
                response.setStatus(false);
                response.setMessage("Username already exists");
                response.setObject(null);
                return response;
            }
            if (fdaIndiaKendraRepository.findByEmail(user.getEmail()) != null) {
                response.setStatus(false);
                response.setMessage("Email already exists");
                response.setObject(null);
                return response;
            }

            System.out.println(user);
            user.setToken(generateUniqueToken());
            fdaIndiaKendraRepository.save(user);
            response.setObject(user);
            response.setStatus(true);
            response.setMessage("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("User not registered successfully");
            response.setObject(null);
            response.setStatus(false);
        }
        return response;
    }

    private long generateUniqueToken() {
        long token;
        Random random = new Random();
        token = 1000000000000000L + (long) (random.nextDouble() * 9000000000000000L);
        return token;
    }

    public UserResponse loginUser(UserRequest loginRequest, String username, String password) {
        UserResponse response = new UserResponse();
        FDAIndiaKendra userNameAndEmail = fdaIndiaKendraRepository.findByUserNameOrEmailAndPassword(
                loginRequest.getUsername(), loginRequest.getUsername(), loginRequest.getPassword());
        try {
            if (userNameAndEmail != null) {
                userNameAndEmail.setPassword(null);
                response.setStatus(true);
                response.setMessage("User login successful");

                // Generate token with session ID and expiry
                String sessionId = UUID.randomUUID().toString();
                Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);
                String token = jwtTokenUtil.generateTokenWithSessionId(userNameAndEmail, sessionId, sessionExpiry);

                response.setToken(token);
                response.setSessionId(sessionId);
                response.setSessionExpiry(sessionExpiry);
                response.setUser(userNameAndEmail);
            } else {
                response.setMessage("Username or email not matched!");
                response.setStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("An error occurred during login.");
            response.setStatus(false);
        }
        return response;
    }

    public FDAIndiaKendra searchByEmail(String email) {
        return fdaIndiaKendraRepository.findByEmail(email);
    }
}
