package Model;

import java.util.*;

import Enums.*;

public class Student extends Person
{
	
	//member
	
	private String m_Email;
	private String m_Password;
	private StudentRequirement m_CurrentReq;
	private Requirements req;
	private DataManager data;

	public Student() { }

	public Student(String i_FirstName, String i_LastName, String i_ID , String i_NumberPhone, String i_Email, String i_Password)
	{
		
		super(i_FirstName, i_LastName,  i_ID, i_NumberPhone);
		m_Email = i_Email;
		m_Password = i_Password;
		m_CurrentReq = new StudentRequirement();
		
	}

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String m_Email) {
		this.m_Email = m_Email;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String m_Password) {
		this.m_Password = m_Password;
	}

	public List<Integer> checkStatus() {

		req = req.getInstance();
		List<Integer> status = new ArrayList<Integer>();
		for (int i=0;i<eTypeOfTreatment.SIZE.getIndex();i++){
			status.add(req.getReq(i)-m_CurrentReq.getReq(i));
		}
		return status;
	}
	
	public Patient findPatient(String i_IdPatient) {

		data = DataManager.getInstance();
		return data.findPatientInData(i_IdPatient);

	}
	
	public void AddPatient() {
		//TODO
		
	}
	
	public void DeletePatient(String i_IdPatient) {
		//TODO
		
	}
	
}

