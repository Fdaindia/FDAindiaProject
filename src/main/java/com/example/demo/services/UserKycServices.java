package com.example.demo.services;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UserKyc;
import com.example.demo.repository.UserKycREpository;

@Service
public class UserKycServices {

    @Autowired
    private UserKycREpository userKycRepository;

    public UserKyc saveUserKyc(String name, String dob,String pancardNumber, String adharNumber, String mobile, String email, String gender,
                               String fatherName, String motherName, String maritalStatus, String spouseName,
                               String ownerAddress, String addressLine1, String addressLine2, String kendrarea,
                               String state, String district, String pincode, String bloodgroup, String medicalHistory,
                               String qualification, MultipartFile aadharCard, MultipartFile panCard,
                               MultipartFile domicile, MultipartFile idProff, MultipartFile lpc) throws IOException {
        UserKyc userKyc = new UserKyc();
        userKyc.setName(name);
        userKyc.setDob(dob);
        userKyc.setAdharNumber(adharNumber);
        userKyc.setPancardNumber(pancardNumber);
        userKyc.setMobile(mobile);
        userKyc.setEmail(email);
        userKyc.setGender(gender);
        userKyc.setFatherName(fatherName);
        userKyc.setMotherName(motherName);
        userKyc.setMaritalStatus(maritalStatus);
        userKyc.setSpouseName(spouseName);
        userKyc.setOwnerAddress(ownerAddress);
        userKyc.setAddressLine1(addressLine1);
        userKyc.setAddressLIne2(addressLine2);
        userKyc.setKendrarea(kendrarea);
        userKyc.setState(state);
        userKyc.setDistrict(district);
        userKyc.setPincode(pincode);
        userKyc.setBloodgroup(bloodgroup);
        userKyc.setMedicalHistory(medicalHistory);
        userKyc.setQualification(qualification);
        return userKycRepository.save(userKyc);
    }

    public UserKyc getUserKyc(Long id) throws IOException {
        UserKyc userKyc = userKycRepository.findById(id).orElseThrow(() -> new RuntimeException("UserKyc not found"));
       
        return userKyc;
    }
}