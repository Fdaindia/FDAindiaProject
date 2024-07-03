package com.example.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.card.security.JwtTokenUtil;
import com.example.demo.entity.FDAIndiaKendra;
import com.example.demo.entity.FdaEmployee;

import com.example.demo.response.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.services.FdaEmployeeService;
import com.example.demo.services.FdaIndiaKendraService;
import com.example.demo.utils.EmployeeCodeGenerator;


@RestController
@RequestMapping("/Hrms/emp")
public class FdaEmployeeController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private FdaEmployeeService fdaEmployeeService;
    @Autowired
    private FdaIndiaKendraService fdaIndiaKendraService;

    @CrossOrigin()
    @PostMapping("/createEmp")
    public FdaEmployee createEmployee(@RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("alternatePhoneNumber") String alternatePhoneNumber, @RequestParam("email") String email,
            @RequestParam("refferedBy") String refferedBy, @RequestParam("bloodGroup") String bloodGroup,
            @RequestParam("fatherName") String fatherName, @RequestParam("motherName") String motherName,
            @RequestParam("relativeNumber") String relativeNumber,
            @RequestParam("permanentAddress") String permanentAddress, @RequestParam("adharCard") String adharCard,
            @RequestParam("temporaryAddress") String temporaryAddress, @RequestParam("panCard") String panCard,
            @RequestParam("password") String password, @RequestParam("location") String location,
            @RequestParam("designation") String designation, @RequestParam("photoPath") MultipartFile photoPath)
            throws IOException {

        FdaEmployee emp = new FdaEmployee();
        emp.setName(name);
        emp.setAdharCard(adharCard);
        emp.setAlternatePhoneNumber(alternatePhoneNumber);
        emp.setBloodGroup(bloodGroup);
        emp.setDesignation(designation);
        emp.setEmail(email);
        emp.setFatherName(fatherName);
        emp.setMotherName(motherName);
        emp.setLocation(location);
        emp.setRelativeNumber(relativeNumber);
        emp.setTemporaryAddress(temporaryAddress);
        emp.setRefferedBy(refferedBy);
        emp.setPhoneNumber(alternatePhoneNumber);
        emp.setPanCard(panCard);
        emp.setPassword(password);
        emp.setPermanentAddress(permanentAddress);
        emp.setEmpCode(EmployeeCodeGenerator.generateEmployeeCode());
        return fdaEmployeeService.createEmployee(emp, photoPath);
    }

    @CrossOrigin()
    @GetMapping("/{id}")
    public Optional<FdaEmployee> getEmployee(@PathVariable Long id) {
        return fdaEmployeeService.getEmployeeById(id);
    }

    @CrossOrigin()
    @PostMapping("/registration")
    public UserResponse registerForHRMS(@RequestBody FdaEmployee emp) {
        return fdaEmployeeService.registerEmployee(emp);
    }

    @CrossOrigin()
    @PostMapping("/hrmslogin")
    public UserResponse hrmsUser(@RequestBody UserRequest request) {
        UserResponse response = new UserResponse();
        System.out.println(request.getUsername() + " " + request.getPassword());
        if (request.getUsername().equals("ADMIN") && request.getPassword().equals("Fdaindia@2024")) {
            response.setStatus(true);
            String sessionId = UUID.randomUUID().toString();
            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);

            FDAIndiaKendra kendra = new FDAIndiaKendra(); // Initialize the object properly
            kendra.setUsername(request.getUsername());
//            FdaEmployee employee = new FdaEmployee(); // Initialize the object properly
//            employee.setUsername(request.getUsername());

           // String token = jwtTokenUtil.generateTokenWithSessionId(employee, sessionId, sessionExpiry);
            String token = jwtTokenUtil.generateTokenWithSessionId(kendra, sessionId, sessionExpiry);
            response.setToken(token);
            response.setSessionId(sessionId);
            response.setSessionExpiry(sessionExpiry);
            response.setMessage("HRMS Login Successful");
        } else {
            response.setStatus(false);
            response.setMessage("Failed");
        }
        return response;
    }

    @GetMapping("/test")
    public String user() {
        System.out.println("Employee hit");
        return "Employee hit";
    }

}
