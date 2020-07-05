package Controller;

import Model.Student;
import View.StudentView;

public class StudentController {
	Student m_student;
	StudentView m_studenView;
	public StudentController(Student student, StudentView studentView) {
		m_student = student;
		m_studenView = studentView;

	}

	public void start() {
		m_studenView.start();
	}
}
