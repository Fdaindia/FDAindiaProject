package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.card.security.JwtTokenUtil;
import com.example.demo.entity.FDAIndiaCard;
import com.example.demo.entity.FDAIndiaKendra;
import com.example.demo.response.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.services.FdaIndiaKendraService;
import com.example.demo.services.UserServices;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/kendra")
public class KendraController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private FdaIndiaKendraService fdaIndiaKendraService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    int count = 1;

    @CrossOrigin()
    @GetMapping("/test")
    public String home() {
        System.out.println("KendraController Hit" + count++);
        return "KendraController Hit";
    }

    @CrossOrigin()
    @PostMapping("/registration")
    public UserResponse registerForKendra(@RequestBody FDAIndiaKendra user) {
        return fdaIndiaKendraService.registerUser(user);
    }
    @CrossOrigin()
    @PostMapping("/login")
    public UserResponse loginForKendra(@RequestBody UserRequest request) {
        System.out.println(request);
        UserResponse response = fdaIndiaKendraService.loginUser(request, request.getUsername(), request.getPassword());

        if (response.isStatus()) { // Changed to isStatus() method
            String sessionId = UUID.randomUUID().toString();
            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);

            String token = jwtTokenUtil.generateTokenWithSessionId(response.getUser(), sessionId, sessionExpiry);
            response.setToken(token);
            response.setSessionId(sessionId);
            response.setSessionExpiry(sessionExpiry);
        }

        return response;
    }



    @CrossOrigin("*")
    @GetMapping("/token/{token}")
    public FDAIndiaCard getUserByToken(@PathVariable Long token) {
        return userServices.getUserByToken(token);
    }

    @CrossOrigin()
    @PostMapping("/byEmail/{email}")
    public FDAIndiaKendra getByEmail(@PathVariable String email) {
        return fdaIndiaKendraService.searchByEmail(email);
    }
}
