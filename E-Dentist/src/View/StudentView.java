package View;

import Controller.StudentController;
import Model.Student;

public class StudentView {

    StudentController m_studentController;

    public StudentView(StudentController studentController) {

         m_studentController =  studentController;
    }

    public void start() {
        System.out.println("--------------------------------");
        System.out.println("What do you like to do?");
        System.out.println("1. Check requirements status");
        System.out.println("2. find file patient(by ID)");
        System.out.println("3. create new patient");

    }
}
