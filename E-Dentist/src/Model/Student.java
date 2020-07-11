package Model;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class Student extends Person
{
		
	private String m_Email;
	private String m_Password;
	private StudentRequirement m_CurrentRequirement;
	private Requirements m_RequirementFromFile;
	private List<Treatment> m_TreatmentWaitingToApprove;
	private List<Treatment> m_TreatmentGraded;
	
	public Student() { }

	public Student(String firstName, String lastName, String id , String numberPhone, String email, String password)
	{
		
		super(firstName, lastName,  id, numberPhone, email);
		
		m_Password = password;
		m_CurrentRequirement = new StudentRequirement();
		m_TreatmentWaitingToApprove = new ArrayList<Treatment>();
		m_TreatmentGraded = new ArrayList<Treatment>();
		
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
	public void updateReq(int index)
	{
		
		m_CurrentRequirement.incRequirement(index);

	}

	public String getM_treatmentUpdates()
	{
		
		String update = "Treatments waiting list is: \n";
		String status ="";
		
		if (m_TreatmentWaitingToApprove.size() == 0) 
		{
			
			update = "No treatments waiting for approval";
		
		}
		else {
			
			for (Treatment treatment : m_TreatmentWaitingToApprove) 
			{
				
				status = (treatment.getStatus()) ? "COMPLETE" : "PENDDING";
				update += "	" + treatment.getM_DateCompleted() + " " + treatment.toString() + " ** changed status to '" + status + "'" + "\n";
			
			}
			
		}
		
		return update;
		
	}
	
	public String getM_TreatmentGraded()
	{
		
		String update = "Treatments graded list is: \n";
		
		for(Treatment treatment : m_TreatmentGraded) 
		{
		
			update += "	 " + treatment.getM_DateGraded() + " " + treatment.toString() + " **New grade update!" + "\n";
		
		}
		
			return update;
			
	}

	public List<Integer> checkStatus() 
	{
		
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		m_RequirementFromFile = m_RequirementFromFile.getInstance();
		List<Integer> status = new ArrayList<Integer>();
		
		for (int i = 0; i < typesOfTreatment.getSize() ; i++)
		{
					
			status.add(m_RequirementFromFile.getRequirement(i) - m_CurrentRequirement.getRequirement(i));
		
		}
		
		return status;
		
	}
	
	public Patient findPatient(String idPatient) 
	{

		DataManager data = DataManager.getInstance();
		
		return data.findPatientInData(idPatient);

	}
	
	public boolean addPatient(String id, String firstName, String lastName, String phone, String email) throws IOException 
	{
		
		boolean patientAdded = false;
		Patient patient;
		DataManager data = DataManager.getInstance();
		
		if(!(data.checkValidity(id,firstName,lastName,phone,email))) 
		{
			
			return patientAdded;
			
		}
		
		patient = new Patient(firstName,lastName,id,phone,email);
		data.addPatient(patient);
		
		return !patientAdded;
	
	}

	public void addTreatment(String patientId, Treatment treatment)
	{
		
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		TreatmentFile file = patient.getM_treatmentFile();
		file.addTreatment(treatment);
	
	}

	public boolean completeTreatment (String patientId, int treatmentIndex)
	{
		
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		Treatment treatment = patient.getM_treatmentFile().getTreatment(treatmentIndex);

		if(treatment == null) 
		{
		
			return false;
		}
		
			return (patient.getM_treatmentFile().completeTreatment(treatment));

	}

	public boolean deleteTreatment (String patientId, int treatmentIndex)
	{
		
		boolean theTreatmentItsNotDelete = false;
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		TreatmentFile treatmentFile = patient.getM_treatmentFile();
		Treatment treatment = treatmentFile.getTreatment(treatmentIndex);

		if(treatment == null || treatment.getStatus()) 
		{
		
			return theTreatmentItsNotDelete;
			
		}
		
		treatmentFile.deleteTreatment(treatmentIndex);
		
		return !theTreatmentItsNotDelete;
		
	}

	@Override
	public void updateAboutComplete(Treatment treatment)
	{
		
		m_TreatmentWaitingToApprove.add(treatment);
	
	}

	@Override
	public void updateAboutDisapprove(Treatment treatment) {}
	
	@Override
	public void updateAboutGrades(Treatment treatment)
	{
		
		m_TreatmentGraded.add(treatment);
	
	}

	public void deleteTreatmentFromWaitinglist(Treatment treatment)
	{
		
		m_TreatmentWaitingToApprove.remove(treatment);
	
	}

	public void addTreatmentToGraded(Treatment treatment)
	{
		
		m_TreatmentGraded.add(treatment);
	
	}
	
}

