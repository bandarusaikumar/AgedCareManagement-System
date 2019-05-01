package com.sim.agedcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sim.agedcare.entity.AdminContact;

public interface AdminContactRepo extends JpaRepository<AdminContact, Long> {
	
	@Query("select ad from AdminContact ad where patientId=:patientId")
	List<AdminContact> findByPatientId(@Param("patientId") long patientId); 

}
