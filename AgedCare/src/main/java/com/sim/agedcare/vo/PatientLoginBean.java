package com.sim.agedcare.vo;

public class PatientLoginBean {
    private String patientName;
    private String patientPassword;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	@Override
	public String toString() {
		return "PatientLoginBean [patientName=" + patientName + ", patientPassword=" + patientPassword + "]";
	}
	
    
    
}
