package Model;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class Treatment implements Serializable
{

	private List<Person> m_ObserverList;
	private String m_Description;
	private String m_TreatmentBy;
	private String m_ValidatedBy;
	private String m_Type;
	private int m_TypeCode;
	private int m_Grade;
	private String m_DateCompleted ="";
	private String m_DateGraded ="";
	private Patient m_Patient;
	private boolean m_TreatmentStatus;
	
	public Treatment(String description,String treatmentBy,String validatedBy,int type,Patient patient)
	{
		
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		DataManager data = DataManager.getInstance();
		m_ObserverList = new ArrayList<Person>();
		m_Description = description;
		m_TreatmentBy = treatmentBy;
		m_ValidatedBy = validatedBy;
		m_Type = typesOfTreatment.getType(type);
		m_TypeCode = type;
		m_Patient = patient;
		m_TreatmentStatus =false;
		m_Grade = -1;
		registerForUpdates(data.findStudent(treatmentBy));
		registerForUpdates(data.findInstructor(validatedBy));

	}

	@Override
	public String toString()
	{
		
		String grade;
		String status;
		
		if (m_Grade == -1) 
		{
			
			grade = "Pending";
			
		}
		else 
			
			grade = Integer.toString(m_Grade);
		
			if(m_TreatmentStatus == true)
			
			     status = "COMPLETED";
		    
		    else 
			
			     status = "PENDING";
			
		        	
		return "{" +
					"Description='" + m_Description + '\'' +
					",Treated By='" + m_TreatmentBy + '\'' +
					", Validated By='" + m_ValidatedBy + '\'' +
					", Type='" + m_Type + '\''+
					", Grade ='" + grade + '\'' +
					", Treatment status ='" + status +'\''+'}';
		
	}

	public void setM_Grade(int m_Grade)
	{
		
		this.m_Grade = m_Grade;
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date now = new Date();
		m_DateGraded = dtf.format(now);
		notifyObserversForGraded();
		
	}

	public String getTreatmentBy() 
	{
		
		return m_TreatmentBy;
		
	}

	public String getM_Type() 
	{
		
		return m_Type;
		
	}

	public int getM_TypeCode()
	{
		
		return m_TypeCode;
		
	}

	public boolean complete() 
	{
		boolean complete = false;
		
		if (m_TreatmentStatus == false)
		{
			
			SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date now = new Date();
			m_TreatmentStatus = true;
			m_DateCompleted = dtf.format(now);
			notifyObserversForComplete();
			complete = !complete;
			
		}
		
		return complete;
		
	}

	public String getM_DateCompleted() 
	{
		
		return m_DateCompleted;
		
	}

	public String getM_DateGraded() 
	{
		
		return m_DateGraded;
		
	}

	public boolean getStatus()
	{
		
		return m_TreatmentStatus;
		
	}
	
	public int getGrade()
	{
		
		return m_Grade;
		
	}
	
	public void setM_treatmentStatus(boolean treatmentStatus) 
	{
		
		this.m_TreatmentStatus = treatmentStatus;
		notifyObserversForDisapprove();
		
	}

	public void registerForUpdates(Person person)
	{
		
		m_ObserverList.add(person);
		
	}
	
	public void unregisterFromUpdates(Person person)
	{
		
		m_ObserverList.remove(person);
		
	}

	private void notifyObserversForDisapprove()
	{
		
		for (Person person : m_ObserverList)
		{
			
			person.updateAboutDisapprove(this);
			
		}
		
	}
	
	public void notifyObserversForComplete()
	{
		
		for (Person person : m_ObserverList)
		{
			
			person.updateAboutComplete(this);
			
		}
		
	}
	
	private void notifyObserversForGraded() 
	{
		
		for (Person person : m_ObserverList)
		{
			
			person.updateAboutGrades(this);
			
		}
		
	}
	
	public String getPatientInfo()
	{
		
		return m_Patient.getM_ID() + " (" + m_Patient.getM_FirstNameOfPerson() + " " + m_Patient.getM_LastNameOfPerson() + ")";
	
	}
	
}







	

	
	
	
	

