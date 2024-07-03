package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fda_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FdaEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String name;
	public FdaEmployee(Long id, String username, String name, String phoneNumber, String alternatePhoneNumber,
			String email, String refferedBy, String bloodGroup, String fatherName, String motherName, String empCode,
			String relativeNumber, String permanentAddress, String adharCard, String temporaryAddress, String panCard,
			String password, String location, String designation, String photoPath) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.email = email;
		this.refferedBy = refferedBy;
		this.bloodGroup = bloodGroup;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.empCode = empCode;
		this.relativeNumber = relativeNumber;
		this.permanentAddress = permanentAddress;
		this.adharCard = adharCard;
		this.temporaryAddress = temporaryAddress;
		this.panCard = panCard;
		this.password = password;
		this.location = location;
		this.designation = designation;
		this.photoPath = photoPath;
	}
	public FdaEmployee() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}
	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRefferedBy() {
		return refferedBy;
	}
	public void setRefferedBy(String refferedBy) {
		this.refferedBy = refferedBy;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getRelativeNumber() {
		return relativeNumber;
	}
	public void setRelativeNumber(String relativeNumber) {
		this.relativeNumber = relativeNumber;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}
	public String getTemporaryAddress() {
		return temporaryAddress;
	}
	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	private String phoneNumber;
	private String alternatePhoneNumber;
	private String email;
	private String refferedBy;
	private String bloodGroup;
	private String fatherName;
	private String motherName;
	private String empCode;
	private String relativeNumber;
	private String permanentAddress;
	private String adharCard;
	private String temporaryAddress;
	private String panCard;
	private String password;
	private String location;
	private String designation;
	private String photoPath;
	
	
}
