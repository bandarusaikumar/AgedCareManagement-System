package com.sim.agedcare.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.agedcare.entity.Doctor;
import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.entity.Nurse;
import com.sim.agedcare.entity.PatientRelation;
import com.sim.agedcare.repo.DoctorRepo;
import com.sim.agedcare.repo.HealthRecordRepo;
import com.sim.agedcare.repo.NurseRepo;
import com.sim.agedcare.repo.PatientRelationRepo;
import com.sim.agedcare.service.HealthRecordService;
import com.sim.agedcare.vo.GetDocInfoBean;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

	@Autowired
	HealthRecordRepo healthRecordRepo;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	NurseRepo nurseRepo;
	
	@Autowired
	PatientRelationRepo patientRelationRepo;
	
	@Override
	public HealthRecord getById(long id) {
		
		return healthRecordRepo.getOne(id);
	}

	@Override
	public List<HealthRecord> getHealthRecords() {
		return healthRecordRepo.findAll();
	}

	@Override
	public HealthRecord save(HealthRecord healthRecord) {		
		return healthRecordRepo.save(healthRecord) ;
	}

	@Override
	public void delete(long id) {
		healthRecordRepo.deleteById(id);		
	}

	@Override
	public List<HealthRecord> getHealthRecords(long patientId) {
		return healthRecordRepo.findByPatientId(patientId);
	}

	@Override
	public List<GetDocInfoBean> getDocInfoBeans(List<HealthRecord> healthRecords) {
		List<GetDocInfoBean> getDocInfoBeans=new ArrayList<>();
		Iterator<HealthRecord> it=healthRecords.iterator();
		GetDocInfoBean getDocInfoBean=null;
		while (it.hasNext()) {			
			HealthRecord healthRecord = (HealthRecord) it.next();
			getDocInfoBean=new GetDocInfoBean();
			getDocInfoBean.setAge(healthRecord.getAge());
			getDocInfoBean.setClaims(healthRecord.getClaims());
			Doctor doctor=doctorRepo.getOne(healthRecord.getDoctorId());
			getDocInfoBean.setDoctorName(doctor.getDoctorName());
			getDocInfoBean.setEmergencyContact(healthRecord.getEmergencyContact());
			getDocInfoBean.setHealthId(healthRecord.getHealthId());
			getDocInfoBean.setHealthInfo(healthRecord.getHealthInfo());
			getDocInfoBean.setHealthSummary(healthRecord.getHealthSummary());
			getDocInfoBean.setMedicare(healthRecord.getMedicare());
			Nurse nurse=nurseRepo.getOne(healthRecord.getNurseId());
			getDocInfoBean.setNurseName(nurse.getName());
			getDocInfoBean.setPatientId(healthRecord.getPatientId());
			getDocInfoBeans.add(getDocInfoBean);		
		}		
		return getDocInfoBeans;
	}

}
