package Controller;

import Model.*;
import View.InstructorView;

import java.util.List;
import java.util.Scanner;

public class InstructorController {

	private Instructor m_Instructor;
	private InstructorView m_InstructorView;

	public InstructorController(Instructor instructor) {
		m_Instructor = instructor;
		m_InstructorView = new InstructorView(this);
	}

	public void start(Scanner scanner) {
		m_InstructorView.start(scanner);
	}

	public List<Integer> showStudentStatus(String studentId) {
		DataManager data = DataManager.getInstance();
		Student student = data.findStudent(studentId);
		if (student != null)
			return student.checkStatus();
		else
			return null;
	}

	public String findPatientFile (String patientId) {
		DataManager data = DataManager.getInstance();
		Patient patient = data.findPatientInData(patientId);
		if (patient !=null){
			TreatmentFile treatmentFile = patient.getM_treatmentFile();
			return treatmentFile.toString();
		}
		else
			return "Patient not found!";

	}

	public String changeReq(String typeCode, String changesTypeVal) {
		int code,reqValue;
		String returnMessage;
		try {
			code = Integer.parseInt(typeCode);
			reqValue = Integer.parseInt(changesTypeVal);

		} catch (NumberFormatException e) {
			return  "invalid type code or value incorrect";
		}
		if (code>=0 && code<TypesOfTreatment.getInstance().getSize() && reqValue>=0){
				m_Instructor.ChangeRequirments(code,reqValue);
				return ("Requirement of " +TypesOfTreatment.getInstance().getType(code) + "changed to "+ changesTypeVal);
		}
		return  "invalid type code or value incorrect";
	}
}
