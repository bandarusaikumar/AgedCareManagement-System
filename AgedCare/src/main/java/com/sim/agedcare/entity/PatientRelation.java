package com.sim.agedcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientRelation {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long pat_relationId;
	 
	 private long patientId;
	 private long doctorId;
	 private long nurseId;
	 @Column(name="nurseVisitingDate",nullable = false)
	 private java.util.Date nurseVisitingDate;
	 private String reason="";
	 
	 	 
	public long getPat_relationId() {
		return pat_relationId;
	}
	
	public void setPat_relationId(long pat_relationId) {
		this.pat_relationId = pat_relationId;
	}
	
	public long getPatientId() {
		return patientId;
	}
	
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	public long getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public long getNurseId() {
		return nurseId;
	}
	
	public void setNurseId(long nurseId) {
		this.nurseId = nurseId;
	}
	
	public java.util.Date getNurseVisitingDate() {
		return nurseVisitingDate;
	}
	
	public void setNurseVisitingDate(java.util.Date nurseVisitingDate) {
		this.nurseVisitingDate = nurseVisitingDate;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}




	@Override
	public String toString() {
		return "PatientRelation [pat_relationId=" + pat_relationId + ", patientId=" + patientId + ", doctorId="
				+ doctorId + ", nurseId=" + nurseId + ", nurseVisitingDate=" + nurseVisitingDate + ", reason=" + reason
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	 
	 
	 
	 
	 
}
