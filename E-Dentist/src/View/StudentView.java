package View;

import Controller.StudentController;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Model.Requirements;
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
                System.out.println("2. Open patient file(by ID)");
                System.out.println("3. Create new patient");
                System.out.println("B. Log out");
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
                System.out.println("B. Go back");
                userInput = scanner.nextLine();
                switch (userInput){
                    case ("1"):
                        System.out.println("--------------------------------------------");
                        System.out.println(m_studentController.showTreatments(patientId));
                        System.out.println("--------------------------------------------");
                        break;
                    case ("2"):
                        completeTreatment(scanner,patientId);
                        break;
                    case ("3"):
                        addTreatment(scanner,patientId);
                        break;
                    case ("4"):
                        deletedTreatment(scanner,patientId);
                        break;
                    case ("b"):
                    case ("B"):
                        stayMenu = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void deletedTreatment(Scanner scanner, String patientId) {
        String selectedTreatmentCode;

        System.out.println(m_studentController.showTreatments(patientId));
        System.out.println("Select treatment code to delete (Please note - you cannot delete a completed treatment");
        selectedTreatmentCode = scanner.nextLine();

        if (m_studentController.deleteTreatment(patientId,selectedTreatmentCode))
            System.out.println("Treatment deleted successfully");
        else
            System.out.println("Treatment deletion failed");
    }

    private void completeTreatment(Scanner scanner, String patientId) {
        String selectedTreatmentCode;

        System.out.println(m_studentController.showTreatments(patientId));
        System.out.println("Select treatment code to start");
        selectedTreatmentCode = scanner.nextLine();

        if (m_studentController.completeTreatment(patientId,selectedTreatmentCode))
            System.out.println("Treatment completed successfully - Wait for instructor approval");
        else
            System.out.println("Treatment completion failed");
    }


    private void createNewPatient(Scanner scanner) throws IOException {
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
        TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
        List<Integer> currentReqStatus= m_studentController.checkStatus();
        System.out.println("--------------------------------------------");
        System.out.println(Requirements.getInstance().toString());
        for (int i=0; i < typesOfTreatment.getSize() ;i++)
            System.out.println(typesOfTreatment.getType(i) + " treatment left to complete: " + currentReqStatus.get(i));

    }
    private void addTreatment(Scanner scanner,String patientId) {
        String i_Description;
        String i_InstructorId;
        String i_Type;
        TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
        System.out.println("--------------------------------------------");
        System.out.println("Enter description:");
        i_Description = scanner.nextLine();
        System.out.println("Enter instructor ID:");
        i_InstructorId = scanner.nextLine();
        System.out.println(typesOfTreatment);
        System.out.println("Select treatment code from the above list");
        i_Type = scanner.nextLine();
        if (m_studentController.addTreatment(i_Description,i_InstructorId,i_Type, patientId)){
            System.out.println("Added treatment successfully");
        }else{
            System.out.println("Instructor not found or type of treatment invalid");
        }

    }
}
