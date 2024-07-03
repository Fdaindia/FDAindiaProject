package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="kendrakyc_tbl")
@Data
public class KendraKyc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String adharNumber;
	public KendraKyc(Long userId, String name, String dob, String adharNumber, String pancardNumber, String mobile,
			String email, String gender, String fatherName, String motherName, String maritalStatus, String spouseName,
			String ownerAddress, String addressLine1, String addressLine2, String kendrarea, String state,
			String district, String pincode, String bloodgroup, String medicalHistory, String qualification,
			String transactionNumber, String village, String block, String adharCardPath, String panCardPath,
			String domicilePath, String lpcPath, String idProofPath, String screenShotPath) {
		super();
		this.userId = userId;
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
		this.addressLine2 = addressLine2;
		this.kendrarea = kendrarea;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.bloodgroup = bloodgroup;
		this.medicalHistory = medicalHistory;
		this.qualification = qualification;
		this.transactionNumber = transactionNumber;
		this.village = village;
		this.block = block;
		this.adharCardPath = adharCardPath;
		this.panCardPath = panCardPath;
		this.domicilePath = domicilePath;
		this.lpcPath = lpcPath;
		this.idProofPath = idProofPath;
		this.screenShotPath = screenShotPath;
	}

	public KendraKyc() {
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getAdharCardPath() {
		return adharCardPath;
	}

	public void setAdharCardPath(String adharCardPath) {
		this.adharCardPath = adharCardPath;
	}

	public String getPanCardPath() {
		return panCardPath;
	}

	public void setPanCardPath(String panCardPath) {
		this.panCardPath = panCardPath;
	}

	public String getDomicilePath() {
		return domicilePath;
	}

	public void setDomicilePath(String domicilePath) {
		this.domicilePath = domicilePath;
	}

	public String getLpcPath() {
		return lpcPath;
	}

	public void setLpcPath(String lpcPath) {
		this.lpcPath = lpcPath;
	}

	public String getIdProofPath() {
		return idProofPath;
	}

	public void setIdProofPath(String idProofPath) {
		this.idProofPath = idProofPath;
	}

	public String getScreenShotPath() {
		return screenShotPath;
	}

	public void setScreenShotPath(String screenShotPath) {
		this.screenShotPath = screenShotPath;
	}

	@Column(nullable = false)
	private String pancardNumber;
	@Column(nullable = false)
	private String mobile;
	@Column(unique = true)
	private String email;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String fatherName;
	@Column(nullable = false)
	private String motherName;
	@Column(nullable = false)
	private String maritalStatus;
	@Column(nullable = true)
	private String spouseName;
	@Column(nullable = false)
	private String ownerAddress;
	@Column(nullable = false)
	private String addressLine1;
	@Column(nullable = true)
	private String addressLine2;
	@Column(nullable = false)
	private String kendrarea;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String district;
	@Column(nullable = false)
	private String pincode;
	@Column(nullable = false)
	private String bloodgroup;
	@Column(nullable = true)
	private String medicalHistory;
	@Column(nullable = false)
	private String qualification;
	@Column(nullable = true)
	private String transactionNumber;
	@Column(nullable = false)
	private String village;
	@Column(nullable = false)
	private String block;

	private String adharCardPath;
	private String panCardPath; 
    private String domicilePath;
    private String lpcPath;
    private String idProofPath;
    
    private String screenShotPath;
    
    
    

	
}
