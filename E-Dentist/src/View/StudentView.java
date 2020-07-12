package View;

import Controller.StudentController;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Model.Requirements;
import Model.TypesOfTreatment;

public class StudentView {

    StudentController m_StudentController;

    public StudentView(StudentController studentController) 
    {
    	
        m_StudentController = studentController;
        
    }

    public void start(Scanner scanner) throws IOException
    {
        
        boolean stayMenu = true;
        String userInput;
        
            while (stayMenu)
            {
            	
                System.out.println("--------------------------------------");
                System.out.println("What do you like to do?");
                System.out.println("1. Check requirements status");
                System.out.println("2. Open patient file(by ID)");
                System.out.println("3. Create new patient");
                System.out.println("4. Check treatments updates");
                System.out.println("B. Log out");
                
                userInput = scanner.nextLine();
                
                switch (userInput)
                {
                
                    case("1"): 
                        showStatus();
                        break;
                    
                    case ("2"):
                        openFilePatient(scanner);
                        break;
                    
                    case ("3"):
                        createNewPatient(scanner);
                        break;
                    
                    case ("4"):
                        checkUpdates();
                        break;
                    
                    case ("B"):                
                    case ("b"):
                        stayMenu = false;
                        break;
                    
                    default:
                        System.out.println("Invalid input");
                        
                }
                
            }

    }
    
    private void checkUpdates() 
    {
    	
        System.out.println("--------------------------------------------");
        System.out.println(m_StudentController.checkUpdates());
        System.out.println("--------------------------------------------");
        System.out.println(m_StudentController.checkGraded());
        
    }

    private void openFilePatient(Scanner scanner) 
    {
    	
        String patientId;
        String userInputInSubMenu; 
        boolean stayMenu = true;
        
        System.out.println("Enter patient ID:");
        patientId = scanner.nextLine();
        
        if(!(m_StudentController.findPatient(patientId))) 
        {
        	
            System.out.println("Patient with id: " + patientId + "not found!");
            
        }
         else {
        	 
            outputString("Opened file!");
            
            while (stayMenu)
            {
            	
                System.out.println("what would you like to do?");
                System.out.println("1. Show treatments details");
                System.out.println("2. Complete treatment");
                System.out.println("3. Add a treatment");
                System.out.println("4. Delete a treatment");
                System.out.println("B. Go back");
                userInputInSubMenu = scanner.nextLine();
                
                switch (userInputInSubMenu)
                {
                
                    case ("1"):
                        System.out.println("--------------------------------------------");
                        System.out.println(m_StudentController.showTreatments(patientId));
                        System.out.println("--------------------------------------------");
                        break;
                    
                    case ("2"):
                        completeTreatment(scanner, patientId);
                        break;
                   
                    case ("3"):
                        addTreatment(scanner, patientId);
                        break;
                   
                    case ("4"):
                        deletedTreatment(scanner, patientId);
                        break;
                   
                    case ("b"):
                    case ("B"):
                        stayMenu = false;
                        break;
                    
                    default:
                        break;
                        
                }
                
            }
            
        }
        
    }

    private void deletedTreatment(Scanner scanner, String patientId) 
    {
    	
        String selectedTreatmentCode;

        System.out.println(m_StudentController.showTreatments(patientId));
        System.out.println("Select treatment code to delete (Please note - you cannot delete a completed treatment");
        selectedTreatmentCode = scanner.nextLine();

        if (m_StudentController.deleteTreatment(patientId,selectedTreatmentCode)) 
        {
       
        	outputString("Treatment deleted successfully");
        
        }
        else {
        	
            outputString("Treatment deletion failed");
    
        }
        
    }
    
    private void completeTreatment(Scanner scanner, String patientId)
    {
        String selectedTreatmentCode;

        System.out.println(m_StudentController.showIncompleteTreatments(patientId));
        System.out.println("Select treatment code to start");
        selectedTreatmentCode = scanner.nextLine();

        if (m_StudentController.completeTreatment(patientId,selectedTreatmentCode)) 
        {
        	
            outputString("Treatment completed successfully - Wait for instructor approval");
        
        }
        else {
        	
        	outputString("Treatment completion failed");
        	
        }
            
    }

    private void createNewPatient(Scanner scanner) throws IOException 
    {
    	
        String id, firstName, lastName, phone, email;

        System.out.println("Enter id:");
        id = scanner.nextLine();

        System.out.println("Enter patient first name:");
        firstName = scanner.nextLine();

        System.out.println("Enter patient last name:");
        lastName = scanner.nextLine();

        System.out.println("Enter patient phone");
        phone = scanner.nextLine();

        System.out.println("Enter patient Email:");
        email = scanner.nextLine();

        if (m_StudentController.createNewPatient(id, firstName, lastName, phone, email)) 
        {
            outputString("Patient added successfully");
        }
         else {
          
        	 outputString("Failed to add patient.");
         
         }
        
    }

    private void showStatus() 
    {
    	
        TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
        List<Integer> currentReqStatus= m_StudentController.checkStatus();
        
        System.out.println("--------------------------------------------");
        System.out.println(Requirements.getInstance().toString());
       
        for (int i = 0; i < typesOfTreatment.getSize(); i++) 
        {
         
        	System.out.println(typesOfTreatment.getType(i) + " treatment left to complete: " + currentReqStatus.get(i));
        
        }
        
    }
    
    private void addTreatment(Scanner scanner,String patientId) 
    {
    	
        String description;
        String instructorId;
        String type;
        TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();
       
        System.out.println("--------------------------------------------");
        System.out.println("Enter description:");
        description = scanner.nextLine();
        
        System.out.println("Enter instructor ID:");
        instructorId = scanner.nextLine();
        
        System.out.println(typesOfTreatment);
        System.out.println("Select treatment code from the above list");
        type = scanner.nextLine();
        
        if (m_StudentController.addTreatment(description, instructorId, type, patientId))
        {
        	
            outputString("Added treatment successfully");
            
        }
        else{
        	
            outputString("Instructor not found or type of treatment invalid");
     
        }

    }
    
    public void boxString (String printOutput)
    {
    	
        int size = printOutput.length();
        
        for (int i = 0; i < size + 8; i++)
        {
         
        	System.out.print("#");
        
        }
        
        System.out.println();

        System.out.println("##  " + printOutput + "  ##");
        
        for (int i = 0; i < size + 8; i++) 
        {

        	System.out.print("#");
        
        }
        
        System.out.println();
        
    }
    
    public void outputString(String printOutput)
    {
    	
        System.out.println("## " + printOutput + " ##");
    
    }

    
}
