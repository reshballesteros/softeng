package domain;

public class ConsultationHistory {
	
	private Patient patient;
	private Physician physician;
	private Consultation consultation;
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Physician getPhysician() {
		return physician;
	}
	
	public void setPhysician(Physician physician) {
		this.physician = physician;
	}
	
	public Consultation getConsultation() {
		return consultation;
	}
	
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

}
