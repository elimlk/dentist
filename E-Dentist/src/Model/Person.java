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
	
	public Person(String firstName, String lastName, String iD , String numberPhone , String email)
	{
		
		this.m_FirstNameOfPerson = firstName;
		this.m_LastNameOfPerson = lastName;
		this.m_ID = iD;
		this.m_NumberPhone = numberPhone;
		this.m_email = email;
			
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

	public abstract void updateAboutComplete(Treatment treatment);
	public abstract void updateAboutGrades(Treatment treatment);
	public abstract void updateAboutDisapprove(Treatment treatment);


}
