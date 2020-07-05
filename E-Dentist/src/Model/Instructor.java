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
	
	public Instructor(String i_FirstName, String i_LastName, String i_ID ,
		String i_NumberPhone, String i_Email, String i_Password) 
	{
		
	    super(i_FirstName, i_LastName ,i_ID , i_NumberPhone,i_Email);
	    m_Password = i_Password;

		
	}
	

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String i_Email) {
		this.m_Email = i_Email;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String i_Password) {
		this.m_Password = i_Password;
	}

	
	
	public void ValidatetTreatment(Treatment i_Treatment) {
	//TODO	
		
	}
	
	public void CheckStatus(String i_StudentID){
		//TODO
		
	}

	public void ChangeRequirments(){
		//TODO
		
	}
	
}
