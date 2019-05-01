package com.sim.agedcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.AdminContact;
import com.sim.agedcare.repo.AdminContactRepo;
import com.sim.agedcare.service.AdminContactService;
import com.sim.agedcare.vo.ContactAdmin;

@Service
public class AdminContactServiceImpl implements AdminContactService {
	
	@Autowired
	AdminContactRepo adminContactRepo;

	@Override
	public AdminContact save(AdminContact adminContact) {
		return adminContactRepo.save(adminContact) ;
	}

	@Override
	public List<AdminContact> getAdminContacts() {		
		return adminContactRepo.findAll();
	}

	@Override
	public AdminContact getAdminContact(long caid) {
		return adminContactRepo.getOne(caid);
	}

	@Override
	public List<AdminContact> getPAdminContacts(long patientId) {
		
		return adminContactRepo.findByPatientId(patientId);
	}

}
