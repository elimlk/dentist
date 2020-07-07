package Model;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;



public class Student extends Person
{
	
	//member
	
	private String m_Email;
	private String m_Password;
	private StudentRequirement m_CurrentRequirement;
	private Requirements m_RequirementFromFile;

	public Student() { }

	public Student(String firstName, String lastName, String iD , String numberPhone, String email, String password)
	{
		
		super(firstName, lastName,  iD, numberPhone,email);
		
		m_Password = password;
		m_CurrentRequirement = new StudentRequirement();
		
	}

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String email) {
		this.m_Email = email;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String password) {
		this.m_Password = password;
	}

	public List<Integer> checkStatus() {
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		m_RequirementFromFile = m_RequirementFromFile.getInstance();
		List<Integer> status = new ArrayList<Integer>();
		
		for (int i = 0; i < typesOfTreatment.getSize() ; i++){
			
			status.add(m_RequirementFromFile.getReq(i) - m_CurrentRequirement.getRequirement(i));
		}
		
		return status;
	}
	
	public Patient findPatient(String idPatient) {

		DataManager data = DataManager.getInstance();
		return data.findPatientInData(idPatient);

	}
	
	public boolean addPatient(String id, String firstName, String lastName, String phone, String email) throws IOException {
		
		boolean patientNotExists = false;
		Patient patient;
		DataManager data = DataManager.getInstance();
		
		if(!(data.checkValidity(id,firstName,lastName,phone,email))) {
			
			return patientNotExists;
		}
		
		patient = new Patient(firstName,lastName,id,phone,email);
		data.addPatient(patient);
		
		return !patientNotExists;
	
	}

	public void addTreatment(String patientId, Treatment treatment){
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		TreatmentFile file = patient.getM_treatmentFile();
		file.addTreatment(treatment);
	}


	public boolean completeTreatment (String patientId, int treatmentIndex){
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		Treatment treatment = patient.getM_treatmentFile().getTreatment(treatmentIndex);
		if(treatment == null)
			return false;
		patient.getM_treatmentFile().completeTreatment(treatment);
		return true;

	}

	public boolean deleteTreatment (String patientId, int treatmentIndex){
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		TreatmentFile treatmentFile = patient.getM_treatmentFile();
		Treatment treatment = treatmentFile.getTreatment(treatmentIndex);

		if(treatment == null || treatment.getStatus())
			return false;

		treatmentFile.deleteTreatment(treatmentIndex);
		return true;
	}

	public void DeletePatient(String idPatient) {
		//TODO
		
	}
	
}

