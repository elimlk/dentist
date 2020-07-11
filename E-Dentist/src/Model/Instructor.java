package Model;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Instructor extends Person
{
     
	private String m_Email;
	private String m_Password;
	private List<Treatment> m_pendingTreatmentList;

	public Instructor(String firstName, String lastName, String iD,
		String numberPhone, String email, String password) 
	{
		
	    super(firstName, lastName ,iD , numberPhone, email);
	    m_Password = password;
	    m_pendingTreatmentList = new ArrayList<Treatment>();
		
	}
	
	public String getM_Email() 
	{
		
		return m_Email;
		
	}

	public void setM_Email(String email) 
	{
		
		this.m_Email = email;
		
	}

	public String getM_Password()
	{
		
		return m_Password;
		
	}

	public void setM_Password(String password)
	{
		
		this.m_Password = password;
		
	}
	
	public boolean pendingUpdates() 
	{
		
		return !(m_pendingTreatmentList.size() == 0);
		
	}

	public void ChangeRequirments(int typeCode, int value)
	{
		
		Requirements requirements = Requirements.getInstance();
		requirements.updateRequirement(typeCode,value);
		
	}

	public String checkUpdates()
	{
		
		String updates = "Treatments waiting your approval:\n";
		
		if (m_pendingTreatmentList.size()==0) 
		{
			
			return "No Treatment waiting for approval";
			
		}
			
		for(int i =0; i< m_pendingTreatmentList.size(); i++)
		{
			
			updates += "("+i+") " + "Treatment of patianet :" + m_pendingTreatmentList.get(i).toString() + "\n";
		
		}
		
		return updates;
		
	}
	
	@Override
	public void updateAboutComplete(Treatment treatment)
	{
		
		m_pendingTreatmentList.add(treatment);
		
	}

	@Override
	public void updateAboutDisapprove(Treatment treatment) {}// do nothing

	@Override
	public void updateAboutGrades(Treatment treatment) { } // do nothing


	public boolean aproveTrearment(String userInput, String grade)
	{
		
		boolean aproveItsNotComplete = false;
		int input = -999;
		int newGrade = -999;
		DataManager data = DataManager.getInstance();
		
		try 
		{
			
			input = Integer.parseInt(userInput);
			newGrade = Integer.parseInt(grade);
			
		}
		catch (NumberFormatException e)
		{
			
			return aproveItsNotComplete;
		
		}

		if(input >= 0 && input < m_pendingTreatmentList.size())
		{
		
			String studentID = m_pendingTreatmentList.get(input).getTreatmentBy();
			
			if((newGrade >= 0) && (newGrade <= 100)) 
			{
				
				m_pendingTreatmentList.get(input).setM_Grade(newGrade);
				data.findStudent(studentID).deleteTreatmentFromWaitinglist(m_pendingTreatmentList.get(input));
				data.findStudent(studentID).updateReq(m_pendingTreatmentList.get(input).getM_TypeCode());
				m_pendingTreatmentList.remove(input);
				
				return !aproveItsNotComplete;
				
			}else
				{
				if(newGrade == -1) 
				{
					
					m_pendingTreatmentList.get(input).setM_treatmentStatus(false);
					m_pendingTreatmentList.remove(input);
					
					return !aproveItsNotComplete;
					
				}
				
			}
			
		}
		
		return aproveItsNotComplete;
		
	}
	
}
