package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UserKyc;
import com.example.demo.services.UserKycServices;

@RestController
@RequestMapping("/user/userkyc")
public class UserKycController {

	@Autowired
	private UserKycServices userKycService;
	
	@CrossOrigin()
	@PostMapping("/upload")
	public ResponseEntity<String> uploadUserKyc(@RequestParam("name") String name, @RequestParam("dob") String dob,
			@RequestParam("adharNumber") String adharNumber,@RequestParam("pancardNumber") String pancardNumber, @RequestParam("mobile") String mobile,
			@RequestParam("email") String email, @RequestParam("gender") String gender,
			@RequestParam("fatherName") String fatherName, @RequestParam("motherName") String motherName,
			@RequestParam("maritalStatus") String maritalStatus, @RequestParam("spouseName") String spouseName,
			@RequestParam("ownerAddress") String ownerAddress, @RequestParam("addressLine1") String addressLine1,
			@RequestParam("addressLine2") String addressLine2, @RequestParam("kendrarea") String kendrarea,
			@RequestParam("state") String state, @RequestParam("district") String district,
			@RequestParam("pincode") String pincode, @RequestParam("bloodgroup") String bloodgroup,
			@RequestParam("medicalHistory") String medicalHistory, @RequestParam("qualification") String qualification,
			@RequestParam("adharCard") MultipartFile adharCard, @RequestParam("panCard") MultipartFile panCard,
			@RequestParam("domicile") MultipartFile domicile, @RequestParam("idProff") MultipartFile idProff,
			@RequestParam("lpc") MultipartFile lpc) {
		try {
			UserKyc userKyc = userKycService.saveUserKyc(name, dob, adharNumber,pancardNumber, mobile, email, gender, fatherName,
					motherName, maritalStatus, spouseName, ownerAddress, addressLine1, addressLine2, kendrarea, state,
					district, pincode, bloodgroup, medicalHistory, qualification, adharCard, panCard, domicile,
					idProff, lpc);
			return ResponseEntity.ok("User KYC uploaded successfully with ID: " + userKyc.getId());
		} catch (IOException e) {
			return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
		}
	}

	@CrossOrigin()
	@PostMapping("getuser/{id}")
	public ResponseEntity<UserKyc> getUserKyc(@PathVariable Long id) {
		try {
			UserKyc userKyc = userKycService.getUserKyc(id);
			return ResponseEntity.ok(userKyc);
		} catch (IOException e) {
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@GetMapping("/test")
	public String user()
	{
		System.out.println("kendra hit");
		return "kendra hit";
	}
	
}