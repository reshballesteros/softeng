package domain;

import java.util.*;

public class BillStatement {
	
	private Statement statement;
	private Patient patient;
	private List<Service> serviceList;
	private Integer quantity;
	private String serviceDate;
	
	public Statement getStatement() {
		return statement;
	}
	
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public List<Service> getServiceList() {
		return serviceList;
	}
	
	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getServiceDate() {
		return serviceDate;
	}
	
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	
}	