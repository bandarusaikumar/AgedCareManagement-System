package com.sim.agedcare.service;

import java.util.List;

import com.sim.agedcare.entity.HealthRecord;
import com.sim.agedcare.vo.GetDocInfoBean;

public interface HealthRecordService {
	
	HealthRecord save(HealthRecord healthRecord);
	HealthRecord getById(long id);
	List<HealthRecord> getHealthRecords();
	void delete(long id);
	List<HealthRecord> getHealthRecords(long patientId);
	List<GetDocInfoBean> getDocInfoBeans(List<HealthRecord>  healthRecords);
}
