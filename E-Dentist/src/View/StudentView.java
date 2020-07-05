package View;

import Controller.StudentController;
import Model.Student;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;
import java.util.Scanner;
import Enums.*;
import Model.TypesOfTreatment;

public class StudentView {

    StudentController m_studentController;

    public StudentView(StudentController studentController) {
        m_studentController = studentController;
    }

    public void start(Scanner scanner) throws IOException {
        //Runtime.getRuntime().exec("cls");
        boolean stayInApp = true;

        String userInput;
            while (stayInApp) {
                System.out.println("--------------------------------------");
                System.out.println("What do you like to do?");
                System.out.println("1. Check requirements status");
                System.out.println("2. find file patient(by ID)");
                System.out.println("3. create new patient");
                System.out.println("B to log out");
                userInput = scanner.nextLine();
                switch (userInput){
                    case("1"): {
                        showStatus();
                        break;
                    }
                    case ("2"):{
                        break;
                    }
                    case ("3"):{
                        break;
                    }
                    case ("B"):{

                    }
                    case ("b"):{
                        stayInApp = false;
                        break;
                    }
                    default:
                        System.out.println("Invalid input");
                }
            }

    }

    private void showStatus() {
        TypesOfTreatment typesOfTreatment = new TypesOfTreatment();
        List<Integer> currentReqStatus= m_studentController.checkStatus();
        System.out.println("--------------------------------------");
        for (int i=0; i < typesOfTreatment.typesArr.length ;i++)
            System.out.println(typesOfTreatment.typesArr[i] + " treatment left to complete: " + currentReqStatus.get(i));

    }
}
