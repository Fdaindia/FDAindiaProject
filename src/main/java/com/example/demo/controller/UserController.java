package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDataDTO;
import com.example.demo.entity.FDAIndiaCard;
import com.example.demo.entity.FDAIndiaKendra;
import com.example.demo.response.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.services.FdaIndiaKendraService;
import com.example.demo.services.UserServices;
import com.example.demo.card.security.JwtTokenUtil;

@RestController
@RequestMapping("/user")
public class UserController {

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
        System.out.println("Registration Hit: " + count++);
        return "";
    }

    @CrossOrigin()
    @PostMapping("/registerforcard")
    public UserResponse registerForCard(@RequestBody FDAIndiaCard user) {
        return userServices.registerUser(user);
    }

    @CrossOrigin()
    @PostMapping("/loginforcard")
    public UserResponse loginForCard(@RequestBody UserRequest request) {
        System.out.println(request);
        UserResponse response = userServices.loginUser(request, request.getPassword(), request.getUsername());

        if (response.isStatus()) { // Changed to isStatus() method
            String sessionId = UUID.randomUUID().toString();
            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);

            FDAIndiaKendra kendra = new FDAIndiaKendra(); // Initialize the object properly
            kendra.setUsername(request.getUsername());

            String token = jwtTokenUtil.generateTokenWithSessionId(kendra, sessionId, sessionExpiry);
            response.setToken(token);
            response.setSessionId(sessionId);
            response.setSessionExpiry(sessionExpiry);
        }

        return response;
    }

//    @CrossOrigin()
//    @PostMapping("/hrmslogin")
//    public UserResponse hrmsUser(@RequestBody UserRequest request) {
//        UserResponse response = new UserResponse();
//        System.out.println(request.getUsername() + " " + request.getPassword());
//        if (request.getUsername().equals("ADMIN") && request.getPassword().equals("Fdaindia@2024")) {
//            response.setStatus(true);
//            String sessionId = UUID.randomUUID().toString();
//            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);
//
//            FDAIndiaKendra kendra = new FDAIndiaKendra(); // Initialize the object properly
//            kendra.setUsername(request.getUsername());
//
//            String token = jwtTokenUtil.generateTokenWithSessionId(kendra, sessionId, sessionExpiry);
//            response.setToken(token);
//            response.setSessionId(sessionId);
//            response.setSessionExpiry(sessionExpiry);
//            response.setMessage("HRMS Login Successful");
//        } else {
//            response.setStatus(false);
//            response.setMessage("Failed");
//        }
//        return response;
//    }

    @CrossOrigin()
    @GetMapping("/allusers")
    public List<UserDataDTO> getAllUser() {
        return userServices.getAllUser();
    }

    @PutMapping("/update/{id}")
    public UserResponse updateEmployee(@PathVariable Long id, @RequestBody FDAIndiaCard fdaIndiaUser) {
        return userServices.updateUser(id, fdaIndiaUser);
    }

    @CrossOrigin("*")
    @GetMapping("/token/{token}")
    public FDAIndiaCard getUserByToken(@PathVariable Long token) {
        return userServices.getUserByToken(token);
    }

    // @CrossOrigin()
    // @PostMapping("/byEmail/{email}")
    // public FDAIndiaKendra getByEmail(@PathVariable String email) {
    // return fdaIndiaKendraService.searchByEmail(email);
    // }
}
