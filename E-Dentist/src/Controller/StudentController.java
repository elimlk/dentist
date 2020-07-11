package Controller;

import Model.*;
import View.StudentView;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentController {
	
	private Student m_student;
	private StudentView m_studentView;
	
	public StudentController(Student student) throws IOException {
		
		m_student = student;
		m_studentView = new StudentView(this);
	
	}

	public void start(Scanner scanner) throws IOException {
		
		m_studentView.start(scanner);
	
	}

	public List<Integer> checkStatus() {
		
		return m_student.checkStatus();
	
	}

	public boolean createNewPatient(String id, String firstName, String lastName, String phone, String email) throws IOException {
		
		return m_student.addPatient(id, firstName, lastName, phone, email);
	
	}


	public boolean findPatient(String patientId) {
		
		boolean PatientItsExists; 
		Patient patient = m_student.findPatient(patientId);
		
		PatientItsExists = patient == null?false:true;
		
		return PatientItsExists;
	
	}
	public String showIncompleteTreatments(String patientId) {
		TreatmentFile treatmentFile = m_student.findPatient(patientId).getM_treatmentFile();

		String incompleteTreatmentFileString = treatmentFile.showIncompleteTreatments();

		return incompleteTreatmentFileString;

	}

	public String showTreatments(String patientId) {

		TreatmentFile treatmentFile = m_student.findPatient(patientId).getM_treatmentFile();

		String treatmentFileString = treatmentFile.toString();

		return treatmentFileString;

	}

	public boolean addTreatment(String i_Description, String i_InstructorId, String i_Type,String patientId) {
		DataManager data = DataManager.getInstance();
		TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
		Treatment treatment;

		try {
			Integer.parseInt(i_Type);
		} catch (NumberFormatException e) {
			return false;
		}


		Instructor instructor = (data.findInstructor(i_InstructorId));
		if (!(instructor == null) && (Integer.parseInt(i_Type)>=0) && ((Integer.parseInt(i_Type)<typesOfTreatment.getSize()))){
			treatment= new Treatment(i_Description,m_student.getM_ID(),i_InstructorId,Integer.parseInt(i_Type),data.findPatientInData(patientId));
			m_student.addTreatment(patientId,treatment);
			return true;
		}
		else
			return false;

	}

	public boolean completeTreatment(String patientId, String selectedTreatmentCode) {

		try {
			Integer.parseInt(selectedTreatmentCode);
		} catch (NumberFormatException e) {
			return false;
		}
		return (m_student.completeTreatment(patientId, Integer.parseInt(selectedTreatmentCode)));


	}

	public boolean deleteTreatment(String patientId, String selectedTreatmentCode) {

		try {
			Integer.parseInt(selectedTreatmentCode);
		} catch (NumberFormatException e) {
			return false;
		}
		return (m_student.deleteTreatment(patientId, Integer.parseInt(selectedTreatmentCode)));
	}

	public String checkUpdates() {
		return m_student.getM_treatmentUpdates();
	}

	public String checkGraded() {
		return m_student.getM_TreatmentGraded();
	}

}
