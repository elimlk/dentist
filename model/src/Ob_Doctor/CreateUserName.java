package Ob_Doctor;

import java.util.*;
import java.io.*;

public class CreateUserName {

	private String m_firstName;
	private String m_LastName;
	private String m_Mail;
	private String m_Geander;
	private String m_City;
	private String m_Campus;
	private String m_Type;
	private String m_Password;
	private int m_PhoneNumber;
	private int m_Id;
	private int m_Age;
  
	private HashMap<String, String> m_ListOfSystem = new HashMap<String, String>();
    
	public CreateUserName() {
		
		
	}
    public CreateUserName(String m_firstName, String m_LastName, String m_Mail, String m_Geander, String m_City,
			String m_Campus, String m_Type,String m_Password,  int m_PhoneNumber, int m_Id, int m_Age) {
		
		this.m_firstName = m_firstName;
		this.m_LastName = m_LastName;
		this.m_Mail = m_Mail;
		this.m_Geander = m_Geander;
		this.m_City = m_City;
		this.m_Campus = m_Campus;
		this.m_Type = m_Type;
		this.m_Password = m_Password;
		this.m_PhoneNumber = m_PhoneNumber;
		this.m_Id = m_Id;
		this.m_Age = m_Age;
		CheckAndAddToList();
		
	}
    
    public void CheckAndAddToList() {
    	
    	
    	if(m_ListOfSystem.containsKey(m_Mail) == false) {
    	         
    		if(this.m_Type == "Student" || this.m_Type == "Lecture") {
    			
    			this.m_ListOfSystem.put(m_Mail, m_Password);
    			    			
    		}
    		
    		
    	}
    	else {
    		
    	      System.out.print("You have user in system");	
    		
    		
    	}
    	
    	
    }

    @SuppressWarnings("resource")
	public void Create() {
    	
    	Scanner myObj = new Scanner(System.in);
    	 String i_firstName;
    	 String i_LastName;
    	 String i_Mail;
    	 String i_Geander;
    	 String i_City;
    	 String i_Campus;
    	 String i_Type;
    	 String i_Password;
    	 int i_PhoneNumber;
    	 int i_Id;
    	 int i_Age;
    	
    	System.out.println("first Name: ");
    	i_firstName = myObj.next();
    	
    	System.out.println("Last Name: ");
    	i_LastName = myObj.next();
    	
    	System.out.println("Password: ");
    	i_Password = myObj.next();
    	
    	System.out.println("Age: ");
    	i_Age = myObj.nextInt();
    	
    	System.out.println("Id: ");
    	i_Id = myObj.nextInt();
    	
    	 System.out.println("Mail: ");
    	i_Mail = myObj.next();
    	
    	System.out.println("City: ");
    	i_City = myObj.next();
    	
    	System.out.println("Student/Lecture: ");
    	i_Type = myObj.next();
    	
    	System.out.println("Name of campus: ");
    	i_Campus = myObj.next();
    	
    	System.out.println("Geander: ");
    	i_Geander = myObj.next();
    	
    	System.out.println("Phone Number: ");
    	i_PhoneNumber = myObj.nextInt();
    	
    	
    	CreateUserName newUser = new CreateUserName(i_firstName, i_LastName, i_Mail, i_Geander, i_City,
    			i_Campus, i_Type,i_Password, i_PhoneNumber, i_Id, i_Age);	
    	
    	
    }
    
	

	public String getM_firstName() {
		return m_firstName;
	}

     
	public void setM_firstName(String m_firstName) {
		this.m_firstName = m_firstName;
	}


	public String getM_LastName() {
		return m_LastName;
	}


	public void setM_LastName(String m_LastName) {
		this.m_LastName = m_LastName;
	}


	public String getM_Mail() {
		return m_Mail;
	}


	public void setM_Mail(String m_Mail) {
		this.m_Mail = m_Mail;
	}


	public String getM_Geander() {
		return m_Geander;
	}


	public void setM_Geander(String m_Geander) {
		this.m_Geander = m_Geander;
	}


	public String getM_City() {
		return m_City;
	}


	public void setM_City(String m_City) {
		this.m_City = m_City;
	}


	public String getM_Campus() {
		return m_Campus;
	}


	public void setM_Campus(String m_Campus) {
		this.m_Campus = m_Campus;
	}


	public String getM_Type() {
		return m_Type;
	}


	public void setM_Type(String m_Type) {
		this.m_Type = m_Type;
	}


	public int getM_PhoneNumber() {
		return m_PhoneNumber;
	}


	public void setM_PhoneNumber(int m_PhoneNumber) {
		this.m_PhoneNumber = m_PhoneNumber;
	}


	public int getM_Id() {
		return m_Id;
	}


	public void setM_Id(int m_Id) {
		this.m_Id = m_Id;
	}


	public int getM_Age() {
		return m_Age;
	}


	public void setM_Age(int m_Age) {
		this.m_Age = m_Age;
	}

}
