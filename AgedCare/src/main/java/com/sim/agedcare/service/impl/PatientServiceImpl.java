package com.sim.agedcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.repo.PatientRelationRepo;
import com.sim.agedcare.repo.PatientRepository;
import com.sim.agedcare.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PatientRelationRepo patientRelationRepo;
	
	@Override
	public Patient getPatientById(Long id) {		
		return patientRepository.getOne(id);
	}

	@Override
	public List<Patient> getPatients() {
		
		return patientRepository.findAll();
	}

	@Override
	public List<PatientRelation> getPatientRelationById(long Id) {
		return patientRelationRepo.findByPatientId(Id);
	}

	@Override
	public List<PatientRelation> getPatientRelations() {
		return patientRelationRepo.findAll() ;
	}

	@Override
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public PatientRelation save(PatientRelation patientRelation) {
		return patientRelationRepo.save(patientRelation) ;
	}

	@Override
	public void delete(long id) {
		patientRelationRepo.deleteById(id);		
	}

}
