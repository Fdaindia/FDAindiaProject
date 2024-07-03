package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDataDTO {
	private Long userId;
	public UserDataDTO(Long userId, String name, String email, String username, String mobile, String state, Long token,
			Double totalAmount, Double deposit, Double withdrwalAmount, Double transaction, Double borrowMoney) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.username = username;
		this.mobile = mobile;
		this.state = state;
		this.token = token;
		this.totalAmount = totalAmount;
		this.deposit = deposit;
		this.withdrwalAmount = withdrwalAmount;
		this.transaction = transaction;
		this.borrowMoney = borrowMoney;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getToken() {
		return token;
	}
	public void setToken(Long token) {
		this.token = token;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getWithdrwalAmount() {
		return withdrwalAmount;
	}
	public void setWithdrwalAmount(Double withdrwalAmount) {
		this.withdrwalAmount = withdrwalAmount;
	}
	public Double getTransaction() {
		return transaction;
	}
	public void setTransaction(Double transaction) {
		this.transaction = transaction;
	}
	public Double getBorrowMoney() {
		return borrowMoney;
	}
	public void setBorrowMoney(Double borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	private String name;
	private String email;
	private String username;
	private String mobile;
	private String state;
	private Long token;
	private Double totalAmount;
	private Double deposit;
	private Double withdrwalAmount;
	private Double transaction;
	private Double borrowMoney;
}
