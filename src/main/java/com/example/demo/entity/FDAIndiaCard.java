package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Fdatable")
@Getter
@Setter
public class FDAIndiaCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	public Long getUserId() {
		return userId;
	}
	public FDAIndiaCard() {
    }
	@JsonCreator
    public FDAIndiaCard(@JsonProperty("userId") Long userId,
                        @JsonProperty("name") String name,
                        @JsonProperty("email") String email,
                        @JsonProperty("username") String username,
                        @JsonProperty("mobile") String mobile,
                        @JsonProperty("state") String state,
                        @JsonProperty("password") String password,
                        @JsonProperty("token") Long token,
                        @JsonProperty("totalAmount") Double totalAmount,
                        @JsonProperty("deposit") Double deposit,
                        @JsonProperty("withdrawalAmount") Double withdrawalAmount,
                        @JsonProperty("transaction") Double transaction,
                        @JsonProperty("borrowMoney") Double borrowMoney) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.mobile = mobile;
        this.state = state;
        this.password = password;
        this.token = token;
        this.totalAmount = totalAmount;
        this.deposit = deposit;
        this.withdrawalAmount = withdrawalAmount;
        this.transaction = transaction;
        this.borrowMoney = borrowMoney;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(Double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
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
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String mobile;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String password;
	private Long token;
	@Column(nullable = true)
	private Double totalAmount;
	@Column(nullable = true)
	private Double deposit;
	@Column(nullable = true)
	private Double withdrawalAmount;
	@Column(nullable = true)
	private Double transaction;
	@Column(nullable = true)
	private Double borrowMoney;

}
