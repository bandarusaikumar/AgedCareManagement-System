package com.sim.agedcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long healthId;
    private String healthInfo;
    private String healthSummary;
    private String claims;
    private String medicare;
    private Integer age;
    private Integer emergencyContact;
    private long patientId;
    private long doctorId;
	private long nurseId;
    
	
	
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

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public Long getHealthId() {
        return healthId;
    }

    public void setHealthId(Long healthId) {
        this.healthId = healthId;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    public String getHealthSummary() {
        return healthSummary;
    }

    public void setHealthSummary(String healthSummary) {
        this.healthSummary = healthSummary;
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }

    public String getMedicare() {
        return medicare;
    }

    public void setMedicare(String medicare) {
        this.medicare = medicare;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Integer emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

	@Override
	public String toString() {
		return "HealthRecord [healthId=" + healthId + ", healthInfo=" + healthInfo + ", healthSummary=" + healthSummary
				+ ", claims=" + claims + ", medicare=" + medicare + ", age=" + age + ", emergencyContact="
				+ emergencyContact + ", patientId=" + patientId + ", doctorId=" + doctorId + ", nurseId=" + nurseId
				+ "]";
	}

	
}
