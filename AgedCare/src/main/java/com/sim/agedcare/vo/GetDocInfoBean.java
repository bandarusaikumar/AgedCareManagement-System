package com.sim.agedcare.vo;

public class GetDocInfoBean {

	private Long healthId;
    private String healthInfo;
    private String healthSummary;
    private String claims;
    private String medicare;
    private Integer age;
    private Integer emergencyContact;
    private long patientId;
    private String doctorName="";
    private String nurseName="";
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
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getNurseName() {
		return nurseName;
	}
	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}
	@Override
	public String toString() {
		return "GetDocInfoBean [healthId=" + healthId + ", healthInfo=" + healthInfo + ", healthSummary="
				+ healthSummary + ", claims=" + claims + ", medicare=" + medicare + ", age=" + age
				+ ", emergencyContact=" + emergencyContact + ", patientId=" + patientId + ", doctorName=" + doctorName
				+ ", nurseName=" + nurseName + "]";
	}
    
    
    
    
}
