package techServ;

import java.sql.*;
import java.util.*;

import domain.Patient;

public class PatientDA {
	
	private Connection conn;
	private ResultSet rs;
	private Patient patient;
	
	private List<Patient> patientList;
	private Integer recordCounter;

	public PatientDA() {
		
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			conn = DriverManager.getConnection ("jdbc:db2://localhost:50000/EMPLOYEE","rachel", "B2llesteros");
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch ( SQLException e)
		{
			e.printStackTrace();
		}
		
		patientList = new ArrayList<Patient>();
		
		try
		{
			PreparedStatement ps = null;
			String query;
			
			query = "SELECT * FROM EMPLIST ORDER BY EMPNO";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				patient = new Patient();
				patient.setPatientNo(rs.getString(1));
				patient.setLastName(rs.getString(2));
				patient.setFirstName(rs.getString(3));
				patient.setMiddleName(rs.getString(4));
				patient.setBirthDate(rs.getString(5));
				patient.setAddress(rs.getString(6));
				
				patientList.add(patient);
			}
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Patient firstPatient() {
		recordCounter = 0;
		return patientList.get(recordCounter);
	}
	
	public Patient searchPatient(String pSearch)
	{
		Patient patientSearch = new Patient();
		
		for (Patient patient: patientList)
		{
			if (patient.getPatientNo().equals(pSearch))
			{
				patientSearch = patient;
				break;
			}
		}
		
		return patientSearch;
	}
	
	public String nextPatientNo()
	{
		patient = new Patient();
		patient = patientList.get(patientList.size()-1);
		
		String lastPatient = patient.getPatientNo();
		Integer patientNoInt = Integer.parseInt(lastPatient.substring(1, 4)) + 1;
		String concatNo = patientNoInt.toString();
		String newPatientNo = null;
		if (concatNo.length() == 1)
		{
			newPatientNo ="P00".concat(concatNo);
		}
		if (concatNo.length() == 2)
		{
			newPatientNo = "P0".concat(concatNo);
		}
		if (concatNo.length() == 3)
		{
			newPatientNo = "P".concat(concatNo);
		}
		
		return newPatientNo;
	}
	
	public void addPatient(Patient patient)
	{
		try
		{
			PreparedStatement ps;
			String query;
			
			query = "INSERT INTO PATIENT (?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, patient.getPatientNo());
			ps.setString(2, patient.getLastName());
			ps.setString(3, patient.getFirstName());
			ps.setString(4, patient.getMiddleName());
			ps.setString(5, patient.getBirthDate());
			ps.setString(6, patient.getAddress());
			
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void savePatient(Patient patient)
	{
		try
		{
			PreparedStatement s = null;
			String query;
			query = "UPDATE patient " +
					"SET lastname=?, " +
					"firstname=?, " +
					"middlename=? " +
					"birthdate=? " +
					"address=? " +
					"WHERE patientNo=?";
			
			s = conn.prepareStatement(query);
			
			s.setString(1, patient.getLastName());
			s.setString(2, patient.getFirstName());
			s.setString(3, patient.getMiddleName());
			s.setString(4, patient.getBirthDate());
			s.setString(5, patient.getAddress());
			s.setString(6, patient.getPatientNo());
			
			s.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
