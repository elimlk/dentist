package Controller;

import Model.*;
import View.StudentView;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentController
{
	
	private Student m_Student;
	private StudentView m_StudentView;
	
	public StudentController(Student student) throws IOException 
	{
		
		m_Student = student;
		m_StudentView = new StudentView(this);
	
	}

	public void start(Scanner scanner) throws IOException
	{
		
		m_StudentView.start(scanner);
	
	}

	public List<Integer> checkStatus() 
	{
		
		return m_Student.checkStatus();
	
	}

	public boolean createNewPatient(String id, String firstName, String lastName, String phone, String email) throws IOException
	{
		
		return m_Student.addPatient(id, firstName, lastName, phone, email);
	
	}

	public boolean findPatient(String patientId) 
	{
		
		boolean PatientItsExists; 
		Patient patient = m_Student.findPatient(patientId);
		
		PatientItsExists = patient == null? false : true;
		
		return PatientItsExists;
	
	}
	
	public String showIncompleteTreatments(String patientId) 
	{
		
		TreatmentFile treatmentFile = m_Student.findPatient(patientId).getM_treatmentFile();

		String incompleteTreatmentFileString = treatmentFile.showInCompleteTreatments();

		return incompleteTreatmentFileString;

	}

	public String showTreatments(String patientId)
	{

		TreatmentFile treatmentFile = m_Student.findPatient(patientId).getM_treatmentFile();

		String treatmentFileString = treatmentFile.toString();

		return treatmentFileString;

	}

	public boolean addTreatment(String description, String instructorId, String type, String patientId)
	{
	
		boolean addTreatmentIsFailed = false;
		DataManager data = DataManager.getInstance();
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		Treatment treatment;

		try
		{
			
			Integer.parseInt(type);
			
		} 
		catch (NumberFormatException e) 
		{
			
			return addTreatmentIsFailed;
			
		}

		Instructor instructor = (data.findInstructor(instructorId));
		
		if (!(instructor == null) && (Integer.parseInt(type) >= 0) && ((Integer.parseInt(type) < typesOfTreatment.getSize())))
		{
			
			treatment= new Treatment(description, m_Student.getM_ID(), instructorId, Integer.parseInt(type),data.findPatientInData(patientId));
			m_Student.addTreatment(patientId,treatment);
			
			addTreatmentIsFailed = !addTreatmentIsFailed;
		
		}	

		return addTreatmentIsFailed;
		
	}

	public boolean completeTreatment(String patientId, String selectedTreatmentCode)
	{

		try 
		{
			Integer.parseInt(selectedTreatmentCode);
			
		} 
		catch (NumberFormatException e)
		{
			
			return false;
			
		}
		
		return (m_Student.completeTreatment(patientId, Integer.parseInt(selectedTreatmentCode)));

	}

	public boolean deleteTreatment(String patientId, String selectedTreatmentCode)
	{

		try 
		{
			
			Integer.parseInt(selectedTreatmentCode);
			
		} 
		catch (NumberFormatException e) 
		{
			return false;
		}
		
		return (m_Student.deleteTreatment(patientId, Integer.parseInt(selectedTreatmentCode)));
	
	}

	public String checkUpdates() 
	{
		
		return m_Student.getM_treatmentUpdates();
		
	}

	public String checkGraded() 
	{
		
		return m_Student.getM_TreatmentGraded();
		
	}

}
