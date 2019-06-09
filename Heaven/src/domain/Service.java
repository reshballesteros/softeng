package domain;

public class Service {
	
	private String serviceCode;
	private String serviceName;
	private String unit;
	private Double unitCost;
	
	public String getServiceCode() {
		return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Double getUnitCost() {
		return unitCost;
	}
	
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
}
