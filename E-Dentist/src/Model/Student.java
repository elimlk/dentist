package Model;

import java.util.*;

import Enums.*;

public class Student extends Person
{
	
	//member
	
	private String m_Email;
	private String m_Password;
	private StudentRequirement m_CurrentRequirement;
	private Requirements m_RequirementFromFile;

	public Student() { }

	public Student(String firstName, String lastName, String iD , String numberPhone, String email, String password)
	{
		
		super(firstName, lastName,  iD, numberPhone,email);
		
		m_Password = password;
		m_CurrentRequirement = new StudentRequirement();
		
	}

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String email) {
		this.m_Email = email;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String password) {
		this.m_Password = password;
	}

	public List<Integer> checkStatus() {

		m_RequirementFromFile = m_RequirementFromFile.getInstance();
		List<Integer> status = new ArrayList<Integer>();
		
		for (int i = 0; i < eTypeOfTreatment.SIZE.getIndex(); i++){
			
			status.add(m_RequirementFromFile.getReq(i) - m_CurrentRequirement.getRequirement(i));
		}
		
		return status;
	}
	
	public Patient findPatient(String idPatient) {

		DataManager data = DataManager.getInstance();
		return data.findPatientInData(idPatient);

	}
	
	public boolean addPatient(String id, String firstName, String lastName, String phone, String email) {
		
		boolean patientNotExists = false;
		Patient patient;
		DataManager data = DataManager.getInstance();
		
		if(!(data.checkValidity(id,firstName,lastName,phone,email))) {
			
			return patientNotExists;
		}
		
		patient = new Patient(firstName,lastName,id,phone,email);
		data.addPatient(patient);
		
		return !patientNotExists;
	
	}
	
	public void DeletePatient(String idPatient) {
		//TODO
		
	}
	
}

