package Model;

import java.io.Serializable;

public abstract class Person  implements Serializable 
{
	
	private String m_FirstNameOfPerson;
	private String m_LastNameOfPerson;
	private String m_Id;
	private String m_NumberPhone;
	private String m_Email;


	//default cto'r
	public Person() {  }
	
	public Person(String firstName, String lastName, String id , String numberPhone , String email)
	{
		
		this.m_FirstNameOfPerson = firstName;
		this.m_LastNameOfPerson = lastName;
		this.m_Id = id;
		this.m_NumberPhone = numberPhone;
		this.m_Email = email;
			
	}

	public String getM_FirstNameOfPerson() 
	{
		
		return m_FirstNameOfPerson;
		
	}

	public String getM_LastNameOfPerson()
	{
		
		return m_LastNameOfPerson;
		
	}

	public String getM_ID() 
	{
		
		return m_Id;
		
	}

	public String getM_NumberPhone()
	{
		
		return m_NumberPhone;
		
	}

	public abstract void updateAboutComplete(Treatment treatment);
	public abstract void updateAboutGrades(Treatment treatment);
	public abstract void updateAboutDisapprove(Treatment treatment);

}
