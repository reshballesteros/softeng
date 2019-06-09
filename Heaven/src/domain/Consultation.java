package domain;

public class Consultation {
	
	private String consultNo;
	private String consultDate;
	private String symptoms;
	private String diagnosis;
	
	public String getConsultNo() {
		return consultNo;
	}
	
	public void setConsultNo(String consultNo) {
		this.consultNo = consultNo;
	}
	
	public String getConsultDate() {
		return consultDate;
	}
	
	public void setConsultDate(String consultDate) {
		this.consultDate = consultDate;
	}
	
	public String getSymptoms() {
		return symptoms;
	}
	
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

}
