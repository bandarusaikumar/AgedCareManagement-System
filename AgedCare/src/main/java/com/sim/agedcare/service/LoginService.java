package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.Nurse;
import com.sim.agedcare.entity.Patient;
import com.sim.agedcare.entity.User;
import com.sim.agedcare.vo.LoginBean;
import com.sim.agedcare.vo.PatientLoginBean;


public interface LoginService {
	
	public User getUser(LoginBean login);
	public Patient getPatient(PatientLoginBean patientLoginBean);
	public User save(User user);
	List<Doctor> getdoctors();
	List<Nurse> getNurses();
	List<Patient> getPatients();
}
