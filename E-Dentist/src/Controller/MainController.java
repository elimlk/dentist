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

    public boolean register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) {
        //valditaion test

    	int id_int = 0;
        boolean validInput = true;

        if (id.length() != 9 && id.length() != 8)
            return !validInput;

/*        try {

            id_int = Integer.parseInt(id);

        } catch (NumberFormatException e) {

        	return validInput;
            //e.printStackTrace();
        }
      //complete validation tests
        if(!(phone.length() == 10))  //phone val

        	return validInput;

        try {

            int replace = Integer.parseInt(phone);

        } catch (NumberFormatException e) {

        	return validInput;
            //e.printStackTrace();
        }
        //email val//
        if(!(email.contains("@") || email.contains(".co.il") ||  email.contains(".com")  || email.contains(".ac.il")))

        	return validInput;

	 if(email.contains("@@"))

		return validInput;*/



        mainModel.register(id,firstName,lastName,phone,email,password,instructor);
        return validInput;
    }

    public void loginAccess(Person p) {
        if (p instanceof Student){
            StudentView studentView = new StudentView();
            StudentController studentController = new StudentController((Student)p,studentView);
            studentController.start();
        }
    }
}
