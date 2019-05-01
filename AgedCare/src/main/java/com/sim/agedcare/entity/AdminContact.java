package com.sim.agedcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminContact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminContactId;
	private long patientId;
	private String patientMailId="";
	private String query="";
	private String answer="";
	
	
	
	public String getPatientMailId() {
		return patientMailId;
	}
	public void setPatientMailId(String patientMailId) {
		this.patientMailId = patientMailId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Long getAdminContactId() {
		return adminContactId;
	}
	public void setAdminContactId(Long adminContactId) {
		this.adminContactId = adminContactId;
	}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	 
	
}
