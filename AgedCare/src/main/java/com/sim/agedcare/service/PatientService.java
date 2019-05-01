package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;

public interface PatientService {
	
	
	Patient save(Patient patient);
	PatientRelation save(PatientRelation patientRelation);
	Patient getPatientById(Long id);
	List<Patient> getPatients();
	List<PatientRelation> getPatientRelationById(long Id);
	List<PatientRelation> getPatientRelations();
	void delete(long id);
}
