package com.example.demo.repository;


import com.example.demo.entity.UserKyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserKycREpository extends JpaRepository<UserKyc, Long> {

	Object findByEmail(String email);
	
}