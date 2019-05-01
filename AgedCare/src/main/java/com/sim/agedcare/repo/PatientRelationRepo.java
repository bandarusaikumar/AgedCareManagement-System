package com.sim.agedcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.agedcare.entity.PatientRelation;

public interface PatientRelationRepo extends JpaRepository<PatientRelation, Long> {	
	
	public List<PatientRelation> findByPatientId(long patientId);
	public PatientRelation findByNurseId(long nurseId);
	

}
