package com.sim.agedcare.vo;

import java.io.Serializable;

public class ContactAdmin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String patientMailId="";
	private String query="";
	private String answer="";
	private long patientId;
	private Long adminContactId;
	
	
	
	public String getPatientMailId() {
		return patientMailId;
	}
	public void setPatientMailId(String patientMailId) {
		this.patientMailId = patientMailId;
	}
	public Long getAdminContactId() {
		return adminContactId;
	}
	public void setAdminContactId(Long adminContactId) {
		this.adminContactId = adminContactId;
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
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "ContactAdmin [patientMailId=" + patientMailId + ", query=" + query + ", answer=" + answer
				+ ", patientId=" + patientId + ", adminContactId=" + adminContactId + "]";
	}
	
	
	

	
}
