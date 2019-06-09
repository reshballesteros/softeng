package domain;

public class Physician {
	
	private String licenseNo;
	private String phyLastName;
	private String phyFirstName;
	private String phyMiddleName;
	private String phyBirthDate;
	private String phyContactNo;
	private String phyAddress;
	private Department dept;
	
	public String getLicenseNo() {
		return licenseNo;
	}
	
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	public String getPhyLastName() {
		return phyLastName;
	}
	
	public void setPhyLastName(String phyLastName) {
		this.phyLastName = phyLastName;
	}
	
	public String getPhyFirstName() {
		return phyFirstName;
	}
	
	public void setPhyFirstName(String phyFirstName) {
		this.phyFirstName = phyFirstName;
	}
	
	public String getPhyMiddleName() {
		return phyMiddleName;
	}
	
	public void setPhyMiddleName(String phyMiddleName) {
		this.phyMiddleName = phyMiddleName;
	}
	
	public String getPhyBirthDate() {
		return phyBirthDate;
	}
	
	public void setPhyBirthDate(String phyBirthDate) {
		this.phyBirthDate = phyBirthDate;
	}
	
	public String getPhyContactNo() {
		return phyContactNo;
	}
	
	public void setPhyContactNo(String phyContactNo) {
		this.phyContactNo = phyContactNo;
	}
	
	public String getPhyAddress() {
		return phyAddress;
	}
	
	public void setPhyAddress(String phyAddress) {
		this.phyAddress = phyAddress;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	

}
