package com.sim.agedcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sim.agedcare.entity.HealthRecord;

public interface HealthRecordRepo extends JpaRepository<HealthRecord, Long> {
	
	@Query("select hr from HealthRecord hr where patientId=:patientId")
	List<HealthRecord> findByPatientId(@Param("patientId") long patientId); 

}
