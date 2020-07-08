package Model;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class Treatment implements Serializable {

	private List<Person> m_observerList;
	private String m_Description;
	private String m_TreatmentBy;
	private String m_ValidatedBy;
	private String m_Type;
	private int m_Grade;
	private Patient m_patient;
	private boolean m_treatmentStatus;

	
	
	public Treatment(String i_Description,String i_TreatmentBy,String i_ValidatedBy,int i_Type,Patient i_patient) {
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		m_observerList = new ArrayList<Person>();
		m_Description = i_Description;
		m_TreatmentBy = i_TreatmentBy;
		m_ValidatedBy = i_ValidatedBy;
		m_Type = typesOfTreatment.getType(i_Type);
		m_patient = i_patient;
		m_treatmentStatus =false;
		m_Grade = -1;


	}


	@Override
	public String toString() {
		String gradeStr;
		String statusStr;
		if (m_Grade == -1)
			gradeStr = "Pending";
		else
			gradeStr = Integer.toString(m_Grade);
		if(m_treatmentStatus == true)
			statusStr = "COMPLETED";
		else
			statusStr = "PENDING";
			return "{" +
					"Description='" + m_Description + '\'' +
					",Treated By='" + m_TreatmentBy + '\'' +
					", Validated By='" + m_ValidatedBy + '\'' +
					", Type='" +m_Type + '\''+
					", Grade ='" +gradeStr + '\'' +
					", Treatment status ='" + statusStr +'\''+'}';
	}

	public void setM_Grade(int m_Grade) {
		this.m_Grade = m_Grade;
	}

	public void complete() {
		m_treatmentStatus=true;
	}

	public boolean getStatus(){
		return m_treatmentStatus;
	}

	public void registerForUpdates(Person person){
		m_observerList.add(person);
	}
	public void unregisterFromUpdates(Person person)
	{
		m_observerList.remove(person);
	}
	public void notifyObservers(){
		for (Person person : m_observerList){
			person.update(this);
		}
	}
	public String getPatientInfo(){
		return m_patient.getM_ID()+" ("+m_patient.getM_FirstNameOfPerson()+" "+m_patient.getM_LastNameOfPerson()+")";
	}
}







	

	
	
	
	

