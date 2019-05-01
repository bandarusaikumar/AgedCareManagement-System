package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.AdminContact;

public interface AdminContactService {
	
	AdminContact save(AdminContact adminContact);
	List<AdminContact> getAdminContacts();
	AdminContact getAdminContact(long caid) ;
	List<AdminContact> getPAdminContacts(long paientId);
	
}
