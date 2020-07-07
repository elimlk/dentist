package Controller;

import Model.Instructor;
import View.InstructorView;

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
}
