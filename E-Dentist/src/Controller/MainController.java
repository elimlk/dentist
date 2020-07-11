package Controller;

import Model.*;
import View.InstructorView;
import View.MainView;
import View.StudentView;

import java.io.IOException;
import java.util.Scanner;

public class MainController {

    MainModel mainModel;

    public MainController() {
        this.mainModel = new MainModel();
    }

    public Person login(String id, String password) {

        Person personIsLive = null;

        if (checkLogin(id)) {

            personIsLive = mainModel.login(id, password);

        }

        return personIsLive;

    }

    public boolean register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) throws IOException {

        return mainModel.register(id, firstName, lastName, phone, email, password, instructor);

    }

    public void loginAccess(Scanner scanner, Person i_Person) throws IOException {

        InstructorController instructorController;
        StudentController studentController;

        if (i_Person instanceof Student) {

            studentController = new StudentController((Student) i_Person);
            studentController.start(scanner);
        }

        if (i_Person instanceof Instructor) {
            instructorController = new InstructorController((Instructor) i_Person);
            instructorController.start(scanner);

        }
    }

    public boolean checkLogin(String id) {

        boolean inputWorng = true;

        if (id.length() != 9 || !(isNumeric(id))) {

            return !inputWorng;

        }

        return inputWorng;
    }

    private boolean isNumeric(String id) {

        boolean isNumeric = false;

        try {

            Integer.parseInt(id);

        } catch (NumberFormatException e) {

            return isNumeric;

        }

        return !isNumeric;

    }

}
