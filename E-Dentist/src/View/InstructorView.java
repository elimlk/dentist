package View;

import Controller.InstructorController;
import Controller.StudentController;
import Model.DataManager;
import Model.Requirements;
import Model.TypesOfTreatment;

import java.util.List;
import java.util.Scanner;

public class InstructorView {

    InstructorController m_InstructorController;

    public InstructorView(InstructorController instructorController) {

        m_InstructorController = instructorController;

    }

    public void start(Scanner scanner) {
        String userInput;
        boolean stayMenu = true;
        while (stayMenu) {
            System.out.println("-------------------------------------");
            System.out.println("What do you like to do?");
            System.out.println("1. See treatments waiting for approval and grading");
            System.out.println("2. Check student status (by ID)");
            System.out.println("3. Show patient file(by ID)");
            System.out.println("4. Change global requirements");
            System.out.println("b. Go back");
            userInput = scanner.nextLine();
            switch (userInput){
                case ("1"):

                    break;
                case ("2"):
                    showStudentStatus(scanner);
                    break;
                case ("3"):
                    showPatientFile(scanner);
                    break;
                case ("4"):
                    changeGlobalReq(scanner);
                    break;
                case ("b"):
                case ("B"):
                    stayMenu = false;
                    break;
                default:
            }
        }
        //return
        /*

        שינוי באופן הכנסת הטיפול
        ההכנסה ראשונית ללא מדריך ובהשלמת הביצוע הוספת מדריך מבקר

         */
    }

    private void changeGlobalReq(Scanner scanner) {
        String typeCode;
        String changesTypeVal;
        System.out.println(Requirements.getInstance().toString());
        boolean stayMenu = true;
        while (stayMenu) {
            System.out.println("Enter type code to change or B to back");
            typeCode = scanner.nextLine();
            if (typeCode.equals("b") || typeCode.equals("B"))
                stayMenu = false;
            else {
                System.out.println("Enter new requirement value:");
                changesTypeVal = scanner.nextLine();
                System.out.println(m_InstructorController.changeReq(typeCode,changesTypeVal));
            }
        }

    }

    private void showPatientFile (Scanner scanner) {
        String patientId;
        System.out.println("Enter patient ID:");
        patientId = scanner.nextLine();
        System.out.println(m_InstructorController.findPatientFile(patientId));
    }

    private void showStudentStatus(Scanner scanner) {
        String studentId;
        TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
        System.out.println("Enter student ID:");
        studentId = scanner.nextLine();
        List<Integer> currentReqStatus = m_InstructorController.showStudentStatus(studentId);
        if(currentReqStatus != null){
            System.out.println("--------------------------------------------");
            for (int i=0; i < typesOfTreatment.getSize() ;i++)
                System.out.println(typesOfTreatment.getType(i) + " treatment left to complete: " + currentReqStatus.get(i));

        }else
            System.out.println("Student with id:'"+studentId+"' not found");

    }
}
