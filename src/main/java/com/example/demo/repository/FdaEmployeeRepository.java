package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FDAIndiaKendra;
import com.example.demo.entity.FdaEmployee;

@Repository
public interface FdaEmployeeRepository extends JpaRepository<FdaEmployee, Long> {
	public Optional<FdaEmployee> findById(Long id);

	@Query("SELECT u FROM FdaEmployee u WHERE (u.username = :username OR u.email = :email) AND u.password = :password")
	public FdaEmployee findByUserNameOrEmailAndPassword(@Param("username") String username,
			@Param("email") String email, @Param("password") String password);
	

	public FdaEmployee findByUsername(String name);

	public FdaEmployee findByEmail(String email);

}
