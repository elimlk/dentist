package Model;

import java.util.Scanner;

import Enums.*;

public class Main {
	
	public static ListOfObject m_ListOfSystem = new ListOfObject();

	public static void main(String[] arguments) {
				
		CreatePerson();

	}
		
	public static void CreatePerson() {
		 
		 Scanner myObj = new Scanner(System.in);
		 String firstNameOfPerson;
		 String lastNameOfPerson;
		 String nameOfAccademy;
		 String password;
		 String mail;
		 String city;
		 String address;
		 String personID;
		 int age;
		 long numberPhone;
		 
		 eStatusOfNewCustomer studentOrLecturer;
		 
		 String message = String.format(" Please enter your first name: ");
		 System.out.print(message);
		 firstNameOfPerson = myObj.nextLine();
		 
		 message = String.format(" Please enter your last name: ");
		 System.out.print(message);
		 lastNameOfPerson = myObj.nextLine();
		 		 		 
		 message = String.format(" Please enter your mail: ");
		 System.out.print(message);
		 mail = myObj.nextLine();
		 
		 message = String.format(" Please enter your password: ");
		 System.out.print(message);
		 password = myObj.nextLine();
		 
		 message = String.format(" Please enter your city: ");
		 System.out.print(message);
		 city = myObj.nextLine();
		 
		 message = String.format(" Please enter your address: ");
		 System.out.print(message);
		 address = myObj.nextLine();
		
		 message = String.format(" Please enter name of accademy that you study: ");
		 System.out.print(message);
		 nameOfAccademy = myObj.nextLine();
		 	 
		 message = String.format(" Please enter your age: ");
		 System.out.print(message);
		 age = myObj.nextInt();
		 
		 message = String.format(" Please enter your ID: ");
		 System.out.print(message);
		 personID = myObj.nextLine();
		 
		 message = String.format(" Please enter your phone number: ");
		 System.out.print(message);
		 numberPhone = myObj.nextLong();
		 
		 message = String.format(" Press 1 if you Student OR "
		 		+ " Press 2 if you Lecturer");
		 System.out.print(message);
		 int choose;
		 choose = myObj.nextInt();
		 	 
		 studentOrLecturer = StatusOfNewCustomerchoose(choose);
	      
		 
		switch(studentOrLecturer) {
		 
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
		
	public static void Status() {}
	
	public static void CreateTreatment() {	}

}
