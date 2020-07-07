package Model;

import java.io.IOException;

public class MainModel {
    
	DataManager m_DataManager;

    public MainModel() {
    	
    	m_DataManager = m_DataManager.getInstance();
    
    }

    public Person login(String id, String password){

        Person person = m_DataManager.findInstructor(id);

        if ( person == null)
        	
        	person = m_DataManager.findStudent(id);

        if (person == null)
        	
            return null; //User not found

        if (person instanceof Instructor)
        {
            if(((Instructor) person).getM_Password().equals(password))
               
            	return person;
        }
        else {
            
        	if (((Student) person).getM_Password().equals(password))
                
        		return person;
        }
        
        return null;
    
    }

    public boolean register(String id, String firstName, String lastName, String phone, String email, String password, boolean instructor) throws IOException {

        if(!(m_DataManager.checkValidity(id, firstName, lastName, phone, email)))
            return false;
       
        Instructor newInstructor;
        Student newStudent;
        
        if(instructor) {
        
        	newInstructor = new Instructor(firstName, lastName, id, phone, email, password);
        	m_DataManager.addInstructor(newInstructor);
        
        }
        else
        {
        
        	newStudent = new Student(firstName,lastName,id,phone,email,password);
        	m_DataManager.addStudent(newStudent);
        
        }

        return true;
        
    }
    
}
