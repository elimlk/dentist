package Controller;

import Model.*;
import View.InstructorView;
import View.MainView;
import View.StudentView;

public class MainController {

    MainModel mainModel;

    public MainController() {
        this.mainModel = new MainModel();
    }

    public Person login(String id, String password) {

        return (mainModel.login(id, password));
    }

    public void loginAccess(Person p) {
        if (p instanceof Student){
            StudentView studentView = new StudentView();
            studentView.start();
        }
    }

    public boolean register(String id, String firstName, String lastName, String phone,String email, String password, boolean instructor) {
        //valditaion test
        int id_int = 0;
        if (!(id.length()==9 || id.length()==8))
            return false;
        try {
            id_int = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return false;
            //e.printStackTrace();
        }
        //complete validation tests

        mainModel.register(id,firstName,lastName,phone,email,password,instructor);
        return true;
    }
}
