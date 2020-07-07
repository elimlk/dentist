package View;

import Controller.InstructorController;

import java.util.Scanner;

public class InstructorView {

    InstructorController m_InstructorController;

    public InstructorView(InstructorController instructorController) {

        m_InstructorController = instructorController;

    }

    public void start(Scanner scanner) {
        System.out.println("-------------------------------------");
        System.out.println("What do you like to do?");
        System.out.println("1. See treatments waiting for approval and grading");
        System.out.println("2. See all treatments under your supervision");
        System.out.println("3. Check student status (by ID)");
        System.out.println("999. Change global requirements");
        //return
        /*

        שינוי באופן הכנסת הטיפול
        ההכנסה ראשונית ללא מדריך ובהשלמת הביצוע הוספת מדריך מבקר

         */
    }
}
