package Model;

import java.io.Serializable;

public abstract class Person  implements Serializable {
	
	private String m_FirstNameOfPerson;
	private String m_LastNameOfPerson;
	private String m_ID;
	private String m_NumberPhone;
	private String m_email;


	//default cto'r
	public Person() {  }
	
	public Person(String i_FirstName, String i_LastName, String i_ID , String i_NumberPhone , String i_Email)
	{
		
		this.m_FirstNameOfPerson = i_FirstName;
		this.m_LastNameOfPerson = i_LastName;
		this.m_ID = i_ID;
		this.m_NumberPhone = i_NumberPhone;
		this.m_email = i_Email;
			
	}



	public String getM_FirstNameOfPerson() {
		return m_FirstNameOfPerson;
	}

	public String getM_LastNameOfPerson() {
		return m_LastNameOfPerson;
	}

	public String getM_ID() {
		return m_ID;
	}

	public String getM_NumberPhone() {
		return m_NumberPhone;
	}
}
