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

    public boolean register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) {
        //valditaion test
        
    	int id_int = 0;
        boolean worangInput = false;
        
        if (id.length() != 9 || id.length() != 8)
        	
            return worangInput;
      
        try {
        	
            id_int = Integer.parseInt(id);
            
        } catch (NumberFormatException e) {
            
        	return worangInput;
            //e.printStackTrace();
        }
      //complete validation tests
        if(!(phone.length() == 10))  //phone val
         
        	return worangInput;
        
        try {
        	
            int_replace = Integer.parseInt(phone);
            
        } catch (NumberFormatException e) {
           
        	return worangInput;
            //e.printStackTrace();
        }
        //email val//
        if(!(email.contains("@") || email.contains(".co.il") ||  email.contains(".com")  || email.contains(".ac.il")))
		
        	return worangInput;
        
	 if(email.contains("@@"))
		 
		return worangInput;

        //complete validation tests

        mainModel.register(id,firstName,lastName,phone,email,password,instructor);
        return !worangInput;
    }
}
