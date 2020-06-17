package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
	
	private String m_FirstNameOfPerson;
	private String m_LastNameOfPerson;
	private String m_Mail;
	private String m_City;
	private String m_Address;
	private int m_Age;
	private long m_ID;
	private long m_NumberPhone;
	private List<Person> m_ListOfPerson = new ArrayList<Person>();
	

	//default cto'r
	public Person() { }
	
	public Person(String i_FirstName, String i_LastName, String i_Mail, String i_City, String i_Address, int i_Age, long i_ID , long i_NumberPhone) 
	{
				
		this.m_FirstNameOfPerson = i_FirstName;
		this.m_LastNameOfPerson = i_LastName;
		this.m_Mail = i_Mail;	
		this.m_City = i_City;
		this.m_Address = i_Address;
		this.m_Age = i_Age;
		this.m_ID = i_ID;
		this.m_NumberPhone = i_NumberPhone;
		
		if(m_ListOfPerson == null) 
		{
			m_ListOfPerson.add(this); 
		}
		else {
			m_ListOfPerson.add(this);
		}
		
	}
	
	public String GetM_FirstNameOfPerson()
	{
		
		return m_FirstNameOfPerson;
		
	}
	
	public void SetM_Name(String i_FirstNameOfPerson) 
	{
		
		this.m_FirstNameOfPerson = i_FirstNameOfPerson;
	
	}
	
	public String getM_LastNameOfPerson()
	{
		
		return m_LastNameOfPerson;
		
	}

	public void setM_LastNameOfPerson(String i_LastNameOfPerson)
	{
		
		this.m_LastNameOfPerson = i_LastNameOfPerson;
		
	}
	
	public String GetM_Mail() 
	{
		
		return m_Mail;
		
	}
	
	public void SetM_Mail(String i_Mail)
	{
		
		this.m_Mail = i_Mail;
		
	}
	
	public String GetM_City() 
	{
		
		return m_City;
		
	}
	
	public void SetM_City(String i_City) 
	{
		
		this.m_City = i_City;
		
	}
	
	public String GetM_Address() 
	{
		
		return m_Address;
		
	}
	
	public void SetM_Address(String i_Address)
	{
		
		this.m_Address = i_Address;
		
	}
	
	public int GetM_Age() 
	{
		
		return m_Age;
		
	}
	
	public void SetM_Age(int i_Age) 
	{
		
		this.m_Age = i_Age;
		
	}
	
	public long GetM_ID() 
	{
		
		return m_ID;
		
	}
	
	public void SetM_ID(long i_ID) 
	{
		
		this.m_ID = i_ID;
		
	}
	
	public long GetM_NumberPhone()
	{
		
		return m_NumberPhone;
		
	}
	
	public void SetM_NumberPhone(long i_NumberPhone) 
	{
		
		this.m_NumberPhone = i_NumberPhone;
		
	}
	
	@Override
	public  String toString() {
			
		String printDeatils = String.format("\nFirst Name: " + m_FirstNameOfPerson 
				+ "\nLast Name: " + m_LastNameOfPerson 
				+ "\nMail: " + m_Mail 
				+ "\nCity: " + m_City 
				+ "\nAddress: " + m_Address
				+ "\nAge: " + m_Age
				+ "\nNumber ID: " + m_ID
				+ "\nNumber of phoner: " + m_NumberPhone);
		
		return printDeatils;
			
	}
	
	
}
