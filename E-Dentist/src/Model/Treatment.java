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
	private String m_DateCompleted ="";
	private String m_DateGraded ="";
	private Patient m_patient;
	private boolean m_treatmentStatus;

	
	
	public Treatment(String i_Description,String i_TreatmentBy,String i_ValidatedBy,int i_Type,Patient i_patient) {
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		DataManager data = DataManager.getInstance();
		m_observerList = new ArrayList<Person>();
		m_Description = i_Description;
		m_TreatmentBy = i_TreatmentBy;
		m_ValidatedBy = i_ValidatedBy;
		m_Type = typesOfTreatment.getType(i_Type);
		m_patient = i_patient;
		m_treatmentStatus =false;
		m_Grade = -1;
		registerForUpdates(data.findStudent(i_TreatmentBy));
		registerForUpdates(data.findInstructor(i_ValidatedBy));

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
		notifyObserversForGraded();
	}



	public String getTreatmentBy() {
		return m_TreatmentBy;
	}

	public int getM_Type() {
		return Integer.parseInt(m_Type);
	}

	public void complete() {
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date now = new Date();
		m_treatmentStatus=true;
		m_DateCompleted = dtf.format(now);
		notifyObserversForComplete();
	}

	public String getM_DateCompleted() {
		return m_DateCompleted;
	}

	public String getM_DateGraded() {
		return m_DateGraded;
	}

	public boolean getStatus(){
		return m_treatmentStatus;
	}

	public void setM_treatmentStatus(boolean m_treatmentStatus) {
		this.m_treatmentStatus = m_treatmentStatus;
	}

	public void registerForUpdates(Person person){
		m_observerList.add(person);
	}
	public void unregisterFromUpdates(Person person)
	{
		m_observerList.remove(person);
	}
	public void notifyObserversForComplete(){
		for (Person person : m_observerList){
			person.updateAboutComplete(this);
		}
	}
	private void notifyObserversForGraded() {
		for (Person person : m_observerList){
			person.updateAboutGrades(this);
		}
	}
	public String getPatientInfo(){
		return m_patient.getM_ID()+" ("+m_patient.getM_FirstNameOfPerson()+" "+m_patient.getM_LastNameOfPerson()+")";
	}

	public int getGrade() {
		return m_Grade;
	}
}







	

	
	
	
	

