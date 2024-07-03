package com.example.demo.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.card.security.JwtTokenUtil;
import com.example.demo.dto.UserDataDTO;
import com.example.demo.entity.FDAIndiaCard;
import com.example.demo.entity.FDAIndiaKendra;
import com.example.demo.repository.FDAIndiaKendraRepository;
import com.example.demo.repository.UserRepsository;
import com.example.demo.response.UserRequest;
import com.example.demo.response.UserResponse;

@Service
public class UserServices {

    @Autowired
    private UserRepsository repository;

    @Autowired
    private FDAIndiaKendraRepository fdaIndiaKendraRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserResponse registerUser(FDAIndiaCard user) {
        UserResponse response = new UserResponse();
        try {
            if (repository.findByUsername(user.getUsername()) != null) {
                response.setStatus(false);
                response.setMessage("Username already exists");
                response.setObject(null);
                return response;
            }
            if (repository.findByEmail(user.getEmail()) != null) {
                response.setStatus(false);
                response.setMessage("Email already exists");
                response.setObject(null);
                return response;
            }

            System.out.println(user);
            user.setToken(generateUniqueToken());
            repository.save(user);
            response.setObject(user);
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

    public UserResponse loginUser(UserRequest loginRequest, String username, String password) {
        UserResponse response = new UserResponse();
        FDAIndiaCard userNameAndEmail = repository.findByUserNameOrEmailAndPassword(loginRequest.getUsername(),
                loginRequest.getUsername(), loginRequest.getPassword());
        try {
            if (userNameAndEmail != null) {
                userNameAndEmail.setPassword(null);
                response.setObject(userNameAndEmail);
                response.setStatus(true);
                response.setMessage("User Login Successful");

                // Generate token and add to response
                String token = jwtTokenUtil.generateToken(userNameAndEmail);
                response.setToken(token); 
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

    public List<UserDataDTO> getAllUser() {
        return repository.findAllUsersWithoutPassword();
    }

    public UserResponse updateUser(Long id, FDAIndiaCard fdaIndiaUser) {
        FDAIndiaCard user = repository.findByUserId(id);
        UserResponse response = new UserResponse();
        if (user != null) {
            user.setUsername(fdaIndiaUser.getUsername());
            user.setEmail(fdaIndiaUser.getEmail());
            user.setName(fdaIndiaUser.getName());
            user.setMobile(fdaIndiaUser.getMobile());
            user.setState(fdaIndiaUser.getState());
            user.setToken(fdaIndiaUser.getToken());
            user.setTotalAmount(fdaIndiaUser.getTotalAmount());
            user.setBorrowMoney(fdaIndiaUser.getBorrowMoney());
            user.setTransaction(fdaIndiaUser.getTransaction());
            user.setDeposit(fdaIndiaUser.getDeposit());
            user.setWithdrawalAmount(fdaIndiaUser.getWithdrawalAmount());
            user.setPassword(fdaIndiaUser.getPassword());
            repository.save(user);
            response.setStatus(true);
            response.setObject(user);
            response.setMessage("User records update successfully");
        } else {
            response.setStatus(false);
            response.setObject(null);
            response.setMessage("User records not updated Successfully");
        }
        return response;
    }

    public FDAIndiaCard getUserByToken(Long token) {
        return repository.findByToken(token);
    }

    public FDAIndiaKendra getUserByEmail(String email) {
        return fdaIndiaKendraRepository.findByEmail(email);
    }
}
