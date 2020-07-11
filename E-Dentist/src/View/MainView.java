package View;

import Controller.InstructorController;
import Controller.MainController;
import Controller.StudentController;
import Model.DataManager;
import Model.Instructor;
import Model.Person;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Scanner;

public class MainView{
    private final MainController mainController;


    public MainView() {
     
    	mainController = new MainController();

        
    }

    public void start() throws IOException {

    	boxString("Welcome to E-Dentist");
        
    	boolean stayInApp = true;
        
    	try (Scanner scanner = new Scanner(System.in)){
           
    		while (stayInApp)
            {
              
            	System.out.println("1. to Login");
                System.out.println("2. to Register");
                System.out.println("Q. to EXIT");

                String userInput = scanner.nextLine();

                switch (userInput)
                {
                
                    case ("1"):
                        login(scanner);
                        break;
                        
                    case ("2"):
                        register(scanner);
                        break;
                        
                    case ("q"):
                    case ("Q"):
                        stayInApp = false;
                        break;
                        
                    default:
                        outputString("Invalid input");
                        break;
                }

            }
    		
        }

    }

    public void login(Scanner scanner) throws IOException{
      
    	System.out.println("--------------------------------------");
    	System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        Person loginAttempt = mainController.login(id,password);

        if (loginAttempt != null)
        {

            outputString("login success!");
            System.out.println("Welcome "+loginAttempt.getM_FirstNameOfPerson());
            mainController.loginAccess(scanner,loginAttempt);
            
        }
        else
           
        	outputString("User not found OR incorrect password");

    }

    public void register(Scanner scanner) throws IOException{
        
    	System.out.println("--------------------------------------");
        System.out.println("1 to register as student");
        System.out.println("2 to register as instructor (password required)");
      
        String validationKey;
        String input = scanner.nextLine();
      
        switch (input)
        {
            case ("1"):
            	
                registertion(scanner,false);
              
            break;
            
            case ("2"):
                DataManager data = DataManager.getInstance();
            	System.out.println("Enter validation key:");
                validationKey = scanner.nextLine();

                if (validationKey.equals(data.getRegisterKey()))
                    registertion(scanner,true);
                
                else
                	
                    outputString("Wrong key");
                
                break;
                
            default:
                outputString("Invalid input");


    }
}

    private void registertion(Scanner scanner,boolean instructor) throws IOException {
        
    	String id,firstName,lastName,phone,email,password;

        System.out.println("Enter id:");
        id = scanner.nextLine();
        
        System.out.println("Enter your first name:");
        firstName = scanner.nextLine();
        
        System.out.println("Enter your last name:");
        lastName = scanner.nextLine();
        
        System.out.println("Enter your phone");
        phone = scanner.nextLine();
        
        System.out.println("Enter your Email:");
        email = scanner.nextLine();
        
        System.out.println("Enter password: ");
        password = scanner.nextLine();
        
        if (mainController.register(id,firstName,lastName,phone,email, password,instructor))
          
        	outputString("Registration successful");
        
        else
           
        	outputString("One or more fields incorrect"); // add specific error code

    }

    public void boxString (String str){
        int size = str.length();
        for (int i = 0; i< size + 8; i++)
            System.out.print("#");

        System.out.println();

        System.out.println("##  "+str+"  ##");
        for (int i = 0; i< size + 8; i++)
            System.out.print("#");

        System.out.println();
    }
    public void outputString(String str){
        System.out.println("## "+str + " ##");
    }

}
