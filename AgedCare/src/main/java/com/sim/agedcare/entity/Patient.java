package com.sim.agedcare.entity;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID")
    private Long patientId;
    @Column(name = "PATIENT_NAME")
    private String patientName;
    @Column(name = "PATIENT_PASSWORD")
    private String patientPassword;
    @Column(name = "PATIENT_ADDRESS")
    private String patientaddress;
    @Column(name = "PATIENT_EMAIL")
    private String patientemail;
    @Column(name = "PATIENT_AGE")
    private String patientage;
    @Column(name = "PATIENT_DISEASE")
    private String patientdisease;
    @Column(name = "PATIENT_CONTACTNUMBER")
    private String patientContactnumber;    
    
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
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
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	public String getPatientemail() {
		return patientemail;
	}
	public void setPatientemail(String patientemail) {
		this.patientemail = patientemail;
	}
	public String getPatientage() {
		return patientage;
	}
	public void setPatientage(String patientage) {
		this.patientage = patientage;
	}
	public String getPatientdisease() {
		return patientdisease;
	}
	public void setPatientdisease(String patientdisease) {
		this.patientdisease = patientdisease;
	}
	public String getPatientContactnumber() {
		return patientContactnumber;
	}
	public void setPatientContactnumber(String patientContactnumber) {
		this.patientContactnumber = patientContactnumber;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientPassword="
				+ patientPassword + ", patientaddress=" + patientaddress + ", patientemail=" + patientemail
				+ ", patientage=" + patientage + ", patientdisease=" + patientdisease + ", patientContactnumber="
				+ patientContactnumber + "]";
	}
    
}
