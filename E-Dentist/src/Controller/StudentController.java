package Controller;

import Model.Patient;
import Model.Student;
import Model.Treatment;
import Model.TreatmentFile;
import View.StudentView;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentController {
	Student m_student;
	StudentView m_studentView;
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

	public boolean createNewPatient(String id, String firstName, String lastName, String phone, String email) {
		m_student.addPatient(id,firstName,lastName,phone,email);
		return true;
	}


	public boolean findPatient(String patientId) {
		Patient p = m_student.findPatient(patientId);
		if (p == null)
			return false;
		return true;
	}

	public String showTreatments(String patientId) {
		TreatmentFile treatmentFile = m_student.findPatient(patientId).getM_treatmentFile();
		String treatmentFileString = treatmentFile.toString();
		return treatmentFileString;
	}
}
