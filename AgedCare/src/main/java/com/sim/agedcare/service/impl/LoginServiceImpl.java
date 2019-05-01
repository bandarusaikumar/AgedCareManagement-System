package com.sim.agedcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.Nurse;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.User;
import com.sim.agedcare.repo.DoctorRepo;
import com.sim.agedcare.repo.NurseRepo;
import com.sim.agedcare.repo.PatientRepository;
import com.sim.agedcare.repo.UserRepo;
import com.sim.agedcare.service.LoginService;
import com.sim.agedcare.vo.LoginBean;
import com.sim.agedcare.vo.PatientLoginBean;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	NurseRepo nurseRepo;
	
	@Autowired
	PatientRepository patientRepository;
	
	public User getUser(LoginBean login) {
		return userRepo.findUser(login.getUsername(), login.getPassword());
	}
	@Override
	public Patient getPatient(PatientLoginBean patientLoginBean) {
		
		return patientRepository.findPatient(patientLoginBean.getPatientName(), patientLoginBean.getPatientPassword()) ;
		//return patientRepository.findByPatientNameAndPatientPassword(patientName, patientPassword);
	}
	@Override
	public User save(User user) {		
		return userRepo.save(user);
	}
	@Override
	public List<Doctor> getdoctors() {		
		return doctorRepo.findAll();
	}
	@Override
	public List<Nurse> getNurses() {		
		return nurseRepo.findAll();
	}
	@Override
	public List<Patient> getPatients() {		
		return patientRepository.findAll();
	}
}
