package Controller;

import Model.*;
import View.InstructorView;
import View.MainView;
import View.StudentView;

import java.io.IOException;
import java.util.Scanner;

public class MainController 
{

    MainModel m_MainModel;
    DataManager m_Data;

    public MainController() 
    {
    	this.m_Data = DataManager.getInstance();
        this.m_MainModel = new MainModel();
    
    }

    public Person login(String id, String password) 
    {

        Person personIsLive = null;

        if (checkLogin(id)) 
        {

            personIsLive = m_MainModel.login(id, password);

        }

        return personIsLive;

    }

    public boolean register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) throws IOException 
    {

    	if(checkIfHaveOtherIdOrEmailInSystem(id)) 
    	{
    		    	
        return m_MainModel.register(id, firstName, lastName, phone, email, password, instructor);

    	}
    	
    	return false;
    	
    }

    public void loginAccess(Scanner scanner, Person person) throws IOException
    {

        InstructorController instructorController;
        StudentController studentController;

        if (person instanceof Student)
        {

            studentController = new StudentController((Student) person);
            studentController.start(scanner);
            
        }

        if (person instanceof Instructor) 
        {
        	
            instructorController = new InstructorController((Instructor) person);
            instructorController.start(scanner);

        }
        
    }

    public boolean checkLogin(String id)
    {

        boolean inputWorng = true;

        if (id.length() != 9 || !(isNumeric(id))) 
        {

            inputWorng = !inputWorng;

        }

        return inputWorng;
        
    }

    private boolean isNumeric(String id) 
    {

        boolean isNumeric = false;

        try 
        {

            Integer.parseInt(id);

        } catch (NumberFormatException e) {

            return isNumeric;

        }

        return !isNumeric;

    }
      
    private boolean checkIfHaveOtherIdOrEmailInSystem(String id) 
    {
    	
	
	try 
	{
	
		Integer.parseInt(id);
		
	}
	catch(NumberFormatException e)
	{
		
		return false;
		
	}
	
    	Instructor instructor = m_Data.findInstructor(id);
    	Student student = m_Data.findStudent(id);
    	boolean itsExsits = true;
    	
    	if(student != null || instructor != null) 
    	{
    		
    		itsExsits = !itsExsits; 
    		
    	}
    	
    	return itsExsits;
    	
    }

}
