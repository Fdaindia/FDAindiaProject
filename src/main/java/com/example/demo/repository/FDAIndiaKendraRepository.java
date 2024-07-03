package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.UserDataDTO;
import com.example.demo.entity.FDAIndiaCard;
import com.example.demo.entity.FDAIndiaKendra;

public interface FDAIndiaKendraRepository extends JpaRepository<FDAIndiaKendra, Long> {
	public FDAIndiaKendra findByUsername(String name);

	public FDAIndiaKendra findByEmail(String email);

	public FDAIndiaKendra findByUserId(Long id);

	public FDAIndiaKendra findByToken(Long token);
	
	@Query("SELECT u FROM FDAIndiaKendra u WHERE (u.username = :username OR u.email = :email) AND u.password = :password")
	public FDAIndiaKendra findByUserNameOrEmailAndPassword(@Param("username") String username,
			@Param("email") String email, @Param("password") String password);
	
	
	   @Query("SELECT new com.example.demo.dto.UserKendraDataDto(u.userId, u.name, u.email, u.username, u.mobile, u.state, u.token) FROM FDAIndiaKendra u")
	    List<UserDataDTO> findAllUsersWithoutPassword();
	

	@Query("SELECT u FROM FDAIndiaKendra u WHERE u.username = :username AND u.email = :email")
	public FDAIndiaCard findByUserNameAndEmail(@Param("username") String username, @Param("email") String email);
}