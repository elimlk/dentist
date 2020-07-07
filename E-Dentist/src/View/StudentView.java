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
        boolean stayMenu = true;

        String userInput;
            while (stayMenu) {
                System.out.println("--------------------------------------");
                System.out.println("What do you like to do?");
                System.out.println("1. Check requirements status");
                System.out.println("2. open patient file(by ID)");
                System.out.println("3. create new patient");
                System.out.println("B to log out");
                userInput = scanner.nextLine();
                switch (userInput){
                    case("1"): {
                        showStatus();
                        break;
                    }
                    case ("2"):{
                        openFilePatient(scanner);
                        break;
                    }
                    case ("3"):{
                        createNewPatient(scanner);
                        break;
                    }
                    case ("B"):{

                    }
                    case ("b"):{
                        stayMenu = false;
                        break;
                    }
                    default:
                        System.out.println("Invalid input");
                }
            }

    }

    private void openFilePatient(Scanner scanner) {
        String patientId;
        String userInput; // user input in sub menu
        boolean stayMenu = true;
        System.out.println("Enter patient ID:");
        patientId = scanner.nextLine();
        if(!(m_studentController.findPatient(patientId)))
            System.out.println("Patient with id: " +patientId+ "not found!");
        else {
            System.out.println("Opened file!");
            while (stayMenu) {
                System.out.println("what would you like to do?");
                System.out.println("1. Show upcoming treatments");
                System.out.println("2. Complete treatment");
                System.out.println("3. Add a treatment");
                System.out.println("4. Delete a treatment");
                System.out.println("B to go back");
                userInput = scanner.nextLine();
                switch (userInput){
                    case ("1"):
                        System.out.println("--------------------------------------------");
                        System.out.println(m_studentController.showTreatments(patientId));
                        System.out.println("--------------------------------------------");
                        break;
                    case ("2"):
                        break;
                    case ("3"):
                        break;
                    case ("4"):
                        break;
                    case ("b"):

                    case ("B"):
                        stayMenu = false;
                        break;
                    default:
                        break;
                }


            }
            /*
                נדרש לייצר מזהה לכל טיפול כדי שהתחלת טיפול תהיה ע"פ מזהה מסויים
            */
        }
    }

    private void createNewPatient(Scanner scanner) {
        String id,firstName,lastName,phone,email;

        System.out.println("Enter id:");
        id = scanner.nextLine();

        System.out.println("Enter patient first name:");
        firstName = scanner.nextLine();

        System.out.println("Enter patient last name:");
        lastName = scanner.nextLine();

        System.out.println("Enter patient phone");
        phone = scanner.nextLine();

        System.out.println("Enter patient Email:");
        email = scanner.nextLine();

        if (m_studentController.createNewPatient(id,firstName,lastName,phone,email))
            System.out.println("Patient added successfully");
        else
            System.out.println("Failed to add add patient.");

    }

    private void showStatus() {
        TypesOfTreatment typesOfTreatment = new TypesOfTreatment();
        List<Integer> currentReqStatus= m_studentController.checkStatus();
        System.out.println("!--------------------------------------!");
        for (int i=0; i < typesOfTreatment.typesArr.length ;i++)
            System.out.println(typesOfTreatment.typesArr[i] + " treatment left to complete: " + currentReqStatus.get(i));

    }
}
