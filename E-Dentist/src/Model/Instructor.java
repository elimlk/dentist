package Model;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import Enums.*; 

public class Instructor extends Person {
     
	private String m_Email;
	private String m_Password;
	private eTypeOfTreatment TypeOfTreatment;
	private DataManager m_Treatment;
	
	public Instructor() { }
	
	public Instructor(String firstName, String lastName, String iD,
		String numberPhone, String email, String password) 
	{
		
	    super(firstName, lastName ,iD , numberPhone, email);
	    m_Password = password;
		
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
		
	public void ValidatetTreatment(Treatment treatment) {
	//TODO	
		
	}
	
	public void CheckStatus(String studentID){
		//TODO
		
	}

	public void ChangeRequirments(){
		//TODO
		
	}
	
}
