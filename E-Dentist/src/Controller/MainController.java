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

        return (mainModel.login(id, password));
    }

    public boolean register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) {

        return mainModel.register(id,firstName,lastName,phone,email,password,instructor);

    }

    public void loginAccess(Scanner scanner,Person p) throws IOException {
        if (p instanceof Student){
            StudentController studentController = new StudentController((Student)p);
            studentController.start(scanner);
        }
    }
}
