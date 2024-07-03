package com.example.demo.services;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.card.security.JwtTokenUtil;
import com.example.demo.entity.FdaEmployee;
import com.example.demo.repository.FdaEmployeeRepository;
import com.example.demo.response.UserRequest;
import com.example.demo.response.UserResponse;

@Service
public class FdaEmployeeService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private FdaEmployeeRepository fdaEmployeeRepository;

    private final String storageDirectory = "C:\\Fda\\KYCData\\UserKycDocument\\Employee";

    public FdaEmployee createEmployee(FdaEmployee fdaEmployee, MultipartFile filePhoto) throws IOException {
        if (filePhoto != null && !filePhoto.isEmpty()) {
            String photo = saveFile(filePhoto);
            fdaEmployee.setPhotoPath(photo);
        }
        return fdaEmployeeRepository.save(fdaEmployee);
    }

    private String saveFile(MultipartFile file) throws IOException {
        File directory = new File(storageDirectory);

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully!");
            } else {
                System.out.println("Failed to create directory!");
            }
        } else {
            System.out.println("Directory already exists.");
        }

        String fileName = file.getOriginalFilename();
        String filePath = directory + "//" + fileName;
        File dest = new File(filePath);
        file.transferTo(dest);
        return filePath;
    }

    public Optional<FdaEmployee> getEmployeeById(Long id) {
        return fdaEmployeeRepository.findById(id);
    }

    public UserResponse loginUser(UserRequest loginRequest, String username, String password) {
        UserResponse response = new UserResponse();
        FdaEmployee userNameAndEmail = fdaEmployeeRepository.findByUserNameOrEmailAndPassword(
                loginRequest.getUsername(), loginRequest.getUsername(), loginRequest.getPassword());
        try {
            if (userNameAndEmail != null) {
                userNameAndEmail.setPassword(null);
                response.setStatus(true);
                response.setMessage("User Login Successful");

                // Generate token and add to response
                String sessionId = UUID.randomUUID().toString();
                Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);

                String token = jwtTokenUtil.generateTokenWithSessionId(userNameAndEmail, sessionId, sessionExpiry);
                response.setToken(token);
                response.setSessionId(sessionId);
                response.setSessionExpiry(sessionExpiry);
                response.setObject(userNameAndEmail);
            } else {
                response.setMessage("Username or email not matched!!");
                response.setStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("An error occurred during login.");
            response.setStatus(false);
        }
        return response;
    }

    public UserResponse registerEmployee(FdaEmployee emp) {
        UserResponse response = new UserResponse();
        try {
            if (fdaEmployeeRepository.findByUsername(emp.getUsername()) != null) {
                response.setStatus(false);
                response.setMessage("Username already exists");
                response.setObject(null);
                return response;
            }
            if (fdaEmployeeRepository.findByEmail(emp.getEmail()) != null) {
                response.setStatus(false);
                response.setMessage("Email already exists");
                response.setObject(null);
                return response;
            }

            fdaEmployeeRepository.save(emp);
            response.setObject(emp);
            response.setStatus(true);
            response.setMessage("User Register successful");
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("User not Registered Successfully");
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
}
