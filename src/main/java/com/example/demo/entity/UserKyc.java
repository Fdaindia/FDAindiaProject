package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "kyctbl")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserKyc {
	public UserKyc(Long id, String name, String dob, String adharNumber, String pancardNumber, String mobile,
			String email, String gender, String fatherName, String motherName, String maritalStatus, String spouseName,
			String ownerAddress, String addressLine1, String addressLIne2, String kendrarea, String state,
			String district, String pincode, String bloodgroup, String medicalHistory, String qualification,
			String adharCard, String panCard, String domicile, String idProff, String lpc) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.adharNumber = adharNumber;
		this.pancardNumber = pancardNumber;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.maritalStatus = maritalStatus;
		this.spouseName = spouseName;
		this.ownerAddress = ownerAddress;
		this.addressLine1 = addressLine1;
		this.addressLIne2 = addressLIne2;
		this.kendrarea = kendrarea;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.bloodgroup = bloodgroup;
		this.medicalHistory = medicalHistory;
		this.qualification = qualification;
		this.adharCard = adharCard;
		this.panCard = panCard;
		this.domicile = domicile;
		this.idProff = idProff;
		this.lpc = lpc;
	}
	public UserKyc() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getPancardNumber() {
		return pancardNumber;
	}
	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLIne2() {
		return addressLIne2;
	}
	public void setAddressLIne2(String addressLIne2) {
		this.addressLIne2 = addressLIne2;
	}
	public String getKendrarea() {
		return kendrarea;
	}
	public void setKendrarea(String kendrarea) {
		this.kendrarea = kendrarea;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	public String getIdProff() {
		return idProff;
	}
	public void setIdProff(String idProff) {
		this.idProff = idProff;
	}
	public String getLpc() {
		return lpc;
	}
	public void setLpc(String lpc) {
		this.lpc = lpc;
	}
	private String dob;
	private String adharNumber;
	private String pancardNumber;
	private String mobile;
	private String email;
	private String gender;;
	private String fatherName;
	private String motherName;
	private String maritalStatus;
	private String spouseName;
	private String ownerAddress;
	private String addressLine1;
	private String addressLIne2;
	private String kendrarea;
	private String state;
	private String district;
	private String pincode;
	private String bloodgroup;
	private String medicalHistory;
	private String qualification;
	
	private String adharCard;
	private String panCard;
	private String domicile;
	private String idProff;	
	private String lpc;
	

}