package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import Enums.StatusOfNewCustomer;

public class Lecture extends Person implements VerfiyTreatment
{
             
	private int m_CodeOfSemester;
	private StatusOfNewCustomer m_Status;
	private String m_NameOfAccademy;
	private ListOfObject m_ListOfLecturer = new ListOfObject();
	 
	public Lecture(String i_FirstName, String i_LastName, String i_Mail, String i_City, String i_Address, int i_Age, long i_ID , long i_NumberPhone,String i_NameOfAccademy, StatusOfNewCustomer i_Status) 
	{
	    super(i_FirstName, i_LastName, i_Mail,  i_City, i_Address,  i_Age, i_ID , i_NumberPhone);
		
	    m_NameOfAccademy = i_NameOfAccademy;
		m_Status = i_Status;
		m_CodeOfSemester = ThreadLocalRandom.current().nextInt(99, 999); 
	    
		if(m_ListOfLecturer == null) 
		{
		m_ListOfLecturer.AddLecturer(this); 
		}
		else {
			m_ListOfLecturer.AddLecturer(this);
		}
	}
	
	
	public StatusOfNewCustomer getM_Status() {
		return m_Status;
}

	public void setM_Status(StatusOfNewCustomer m_Status) {
		this.m_Status = m_Status;
	}


	public int getM_CodeOfSemester() {
		return m_CodeOfSemester;
	}
		
	public String getM_NameOfAccademy() {
		return m_NameOfAccademy;
	}

	public void setM_NameOfAccademy(String m_NameOfAccademy) {
		this.m_NameOfAccademy = m_NameOfAccademy;
	}
		
	private void PrintDeatilsOfLuctuer() {
						
		System.out.println();		
	
	}

	private void searchStudent(String i_ID) {
		
		
		
		
	}
		
	public void CreateRequirements() {
		
		Scanner myObj = new Scanner(System.in);
		boolean finsihToInput = false;
		int numberOfCreadits = 0;
		String requirements;
		String typeOfTreatment;
		String finish;
		
		
		while(finsihToInput != false) {
			
			System.out.print("Please enter type of tretamnet: ");
			typeOfTreatment = myObj.nextLine();
					
			System.out.print("Please enter requirements: ");
			requirements = myObj.nextLine();
			
			System.out.print("Please enter Creadit for requiremnts: ");
			numberOfCreadits = myObj.nextInt();
			
			Requirements newRequitrements = new Requirements(requirements, typeOfTreatment, numberOfCreadits);
			
			
			System.out.print(" Write Exit to finish or Press Enter to keep: ");
			finish = myObj.nextLine();
			
			if(finish == "Exit") {
				
				finsihToInput = !finsihToInput;
				
			}
					
		}
				
	}
	
	private class Requirements{
		
		  private String m_Requirements;
		  private String m_TypeOfTreatment;
		  private int m_Creadits;
		
		public Requirements(String i_Requirements, String i_TypeOfTreatment, int i_Creadits)
		{
			
			m_Requirements = i_Requirements;
			m_TypeOfTreatment = i_TypeOfTreatment;
			m_Creadits = i_Creadits;
		}

		public String getM_Requirements() {
			return m_Requirements;
		}

		public void setM_Requirements(String m_Requirements) {
			this.m_Requirements = m_Requirements;
		}

		public String getM_TypeOfTreatment() {
			return m_TypeOfTreatment;
		}

		public void setM_TypeOfTreatment(String m_TypeOfTreatment) {
			this.m_TypeOfTreatment = m_TypeOfTreatment;
		}

		public int getM_Creadits() {
			return m_Creadits;
		}

		public void setM_Creadits(int m_Creadits) {
			this.m_Creadits = m_Creadits;
		}
		
	}
	
	@Override
	public String toString() {
		
		String message = String.format("\nYour code of semster: " + getM_CodeOfSemester() 
		+ "\nStatus: " + getM_Status()
		+"\nName of accademy: " + getM_NameOfAccademy());
		
		return super.toString() + message; 
		
		
	}


	@Override
	public void SearchStudent(String i_ID) {
		// TODO Auto-generated method stub
		
	}
	
}
