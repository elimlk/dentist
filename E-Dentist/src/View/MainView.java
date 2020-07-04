package View;

import Controller.InstructorController;
import Controller.MainController;
import Controller.StudentController;
import Model.Instructor;
import Model.Person;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Scanner;

public class MainView {
    private final MainController mainController;

    private final StudentView studentView;
    private final InstructorView instructorView;
    private final StudentController studentController;
    private final InstructorController instructorController;

    public MainView() {
     
    	mainController = new MainController();

        this.studentView = new StudentView();
        this.instructorView = new InstructorView();
        this.studentController = new StudentController();
        this.instructorController = new InstructorController();
        
    }

    public void start() throws IOException {
        
    	System.out.println("Welcome to E-Dentist");
        
    	boolean stayInApp = true;
        
    	try (Scanner scanner = new Scanner(System.in)){
           
    		while (stayInApp)
            {
              
            	System.out.println("1 to Login");
                System.out.println("2 to Register");
                System.out.println("Q to EXIT");

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
                        stayInApp=false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

            }
    		
        }

    }

    public void login(Scanner scanner) throws IOException{
        
    	System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        Person loginAttempt = mainController.login(id,password);

        if (loginAttempt != null)
        {
           
        	System.out.println("login success!");
            System.out.println("Welcome "+loginAttempt.getM_FirstNameOfPerson());
            mainController.loginAccess(loginAttempt);
        }
        else
           
        	System.out.println("User not found OR incorrect password");

    }

    public void register(Scanner scanner) throws IOException{

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
              
            	System.out.println("Enter validation key:");
                validationKey = scanner.nextLine();
              
                if (validationKey.equals("1234")) // change to Enum
                	
                    registertion(scanner,true);
                
                else
                	
                    System.out.println("Wrong key");
                
                break;
                
            default:
                System.out.println("Invalid input");


    }
}

    private void registertion(Scanner scanner,boolean instructor) {
        String id,firstName,lastName,phone,email,password;

        System.out.println("Enter id: (without 0 on start)");
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
        
        mainController.register(id,firstName,lastName,phone,email,password,instructor);

    }




}
