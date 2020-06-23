package Model;

import java.util.*;

import Enums.StatusOfNewCustomer;

public class Student extends Person
{
	
	//member
	private int m_NumberOfTreatment;
	private int m_Credits;
	private int m_CodeOfCourses;
	private String m_NameOfAccademiStudy;
	private ListOfObject m_ListOfStudent;
	private Treatment m_AddTreatment;
	private StatusOfNewCustomer m_Status;
	private String m_NameOfAccademy;
	
	
	public Student() { }

	public Student(String i_FirstName, String i_LastName, String i_Mail, String i_City, String i_Address, int i_Age, long i_ID , long i_NumberPhone, String i_NameOfAccademy, StatusOfNewCustomer i_Status)          
	{
		
		super(i_FirstName, i_LastName, i_Mail, i_City, i_Address, i_Age, i_ID, i_NumberPhone);
		this.m_NumberOfTreatment = 0;
		this.m_Credits = 0;
		m_NameOfAccademy = i_NameOfAccademy;
		m_Status = i_Status;

			
	}

  
	public int GetM_NumberOfTreatment() {
		
		return m_NumberOfTreatment;
		
	}

	public void SetM_NumberOfTreatment(int i_NumberOfTreatment) {
		
		this.m_NumberOfTreatment = i_NumberOfTreatment;
		
	}

	public int GetM_Credits() {
		
		return m_Credits;
		
	}

	public void SetM_Credits(int i_Credits) {
		
		this.m_Credits = i_Credits;
		
	}

	public Treatment getM_AddTreatment() {
		
		return m_AddTreatment;
	
	}

	public void setM_AddTreatment(Treatment m_AddTreatment) {
	
		this.m_AddTreatment = m_AddTreatment;
	
	}
	
	public int getM_CodeOfCourses() {
		
		return m_CodeOfCourses;
	
	}

	public void setM_CodeOfCourses(int m_CodeOfCourses) {
	
		this.m_CodeOfCourses = m_CodeOfCourses;
	
	}
	
	public ListOfObject getM_ListOfStudent() {
		return m_ListOfStudent;
	}

	public void setM_ListOfStudent(ListOfObject m_ListOfStudent) {
		this.m_ListOfStudent = m_ListOfStudent;
	}
	
	public StatusOfNewCustomer GetM_Status() {
		return m_Status;
	}

	public void setM_Status(StatusOfNewCustomer m_Status) {
		this.m_Status = m_Status;
	}
	
	public String GetM_NameOfAccademy() {
		return m_NameOfAccademy;
	}

	public void setM_NameOfAccademy(String m_NameOfAccademy) {
		this.m_NameOfAccademy = m_NameOfAccademy;
	}
	
	public void GetDeatilsAboutYourCourse() {

		
	    		
		
	}
	
	@Override
	public String toString() {
		
		String message = String.format("\nName of accademy: " + GetM_NameOfAccademy()
				+ "\nNumber of credit: " + GetM_Credits()
				+ "\nStatus in accademy: " + GetM_Status());
		
		return super.toString() + message;
		
	}

	

	

	


	
	
}

