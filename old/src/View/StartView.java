package View;

import java.util.Scanner;
import java.util.*;
import Enums.eStatusOfNewCustomer;
import Model.Lecturer;
import Model.ListOfObject;
import Model.Person;
import Model.Student;

public class StartView 
{
	
	private static ListOfObject m_ListOfSystem = new ListOfObject();
	private static List<Person> m_Person = new ArrayList<Person>();
	private static String FILEPERSONOFSYSTEM = "System.data";	
	
	public StartView() {
		// TODO Auto-generated constructor stub
	}

	public void Start() {
		
		
		boolean connectOrNot = true;
		
		try(Scanner userInput = new Scanner(System.in)){
			
			
			while(connectOrNot) 
			{
				
				String message = String.format(" 1. Login\n"
						+ " 2. Register\n"
						+ " 9. Exit\n");
				System.out.print(message);
				
				String userChoose = userInput.nextLine();
				
				switch(userChoose) {
				
				case "1":
					
					    this.login(userInput);
					break;
					
				case "2": 
					    this.createNewCustomer(userInput);					   
					break;
					
				case "9":
					
					 connectOrNot = !connectOrNot;
					break;
					
					default:
						System.out.print("Please press one from options");
							
				}
				
			}
						
		}
			
	}
		
	
	
private static void login(Scanner i_UserInput) {
	
	String userName;
	String password;
	eStatusOfNewCustomer userType;
	
	m_Person = m_ListOfSystem.getM_ListOfPerson();
	
	System.out.print("User Name(ID): ");
	userName = i_UserInput.nextLine();
	
	System.out.print("Password: ");
	password = i_UserInput.nextLine();
	
	for(Person person: m_Person) {
		
		if(person.GetM_ID().equals(userName) && person.getM_Password().equals(password)) {
				
			userType = person.getM_StatusOfPersonInSystem();
			break;
			
		}
		
	}
	
}
	
private static void createNewCustomer(Scanner i_UserInput)
{
	
	String firstNameOfPerson;
	 String lastNameOfPerson;
	 String nameOfAccademy;
	 String password;
	 String mail;
	 String city;
	 String address;
	 String personID;
	 String numberPhone;
	 int age;
		 
	 eStatusOfNewCustomer studentOrLecturer;
	 
	 
	 String message = String.format(" Please enter your first name: ");
	 System.out.print(message);
	 firstNameOfPerson = i_UserInput.nextLine();
	 
	 message = String.format(" Please enter your last name: ");
	 System.out.print(message);
	 lastNameOfPerson = i_UserInput.nextLine();
	 		 		 
	 message = String.format(" Please enter your mail: ");
	 System.out.print(message);
	 mail = i_UserInput.nextLine();
	 
	 message = String.format(" Please enter your password: ");
	 System.out.print(message);
	 password = i_UserInput.nextLine();
	 
	 message = String.format(" Please enter your city: ");
	 System.out.print(message);
	 city = i_UserInput.nextLine();
	 
	 message = String.format(" Please enter your address: ");
	 System.out.print(message);
	 address = i_UserInput.nextLine();
	
	 message = String.format(" Please enter name of accademy that you study: ");
	 System.out.print(message);
	 nameOfAccademy = i_UserInput.nextLine();
	 	 
	 message = String.format(" Please enter your age: ");
	 System.out.print(message);
	 age = i_UserInput.nextInt();
	 
	 message = String.format(" Please enter your ID: ");
	 System.out.print(message);
	 personID = i_UserInput.nextLine();	
	 
	 message = String.format(" Please enter your phone number: ");
	 System.out.print(message);
	 numberPhone = i_UserInput.nextLine();
	 
	 message = String.format(" Press 1 if you Student OR "
	 		+ " Press 2 if you Lecturer");
	 System.out.print(message);
	 int choose;
	 choose = i_UserInput.nextInt();
	 	 
	 studentOrLecturer = StatusOfNewCustomerchoose(choose);
     
	 
	switch(studentOrLecturer)
	{
	 
	case Student:
	 Person newPerson = new Student(firstNameOfPerson, lastNameOfPerson, mail, city, address, age, personID, numberPhone,nameOfAccademy, studentOrLecturer, password);
	 System.out.println(newPerson.toString()); 
	 m_ListOfSystem.AddPerson(newPerson);
	
	 break;
	 
	case Lecturer:
	 Person newPerson2 = new Lecturer(firstNameOfPerson, lastNameOfPerson, mail, city, address, age, personID, numberPhone, nameOfAccademy, studentOrLecturer, password); 
	 System.out.println(newPerson2.toString());
	 m_ListOfSystem.AddPerson(newPerson2);
	
	 break;    
	
	}
		 
}
	
	 public static eStatusOfNewCustomer StatusOfNewCustomerchoose(int i_StudentOrLecturer) {
			
			eStatusOfNewCustomer c = null;
			
			if(i_StudentOrLecturer == 1) {
				 c = c.Student;
			}
					
			else if(i_StudentOrLecturer == 2) {
				     c = c.Lecturer;
			         
		}   
						 
			return c;
			
		}
	
private static void back(Scanner i_UserInput) {
	
	String back = i_UserInput.nextLine();
	
}
	 
	 
	
		
	
		
}