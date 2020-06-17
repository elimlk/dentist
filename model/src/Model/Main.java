package Model;

import java.util.Scanner;

import Enums.StatusOfNewCustomer;

public class Main {

	public static void main(String[] arguments) {
	
		ListOfObject listOfSystem = new ListOfObject();
				
		CreatePerson();

	}
		
	public static void CreatePerson() {
		 
		 Scanner myObj = new Scanner(System.in);
		 String firstNameOfPerson;
		 String lastNameOfPerson;
		 String nameOfAccademy;
		 String mail;
		 String city;
		 String address;
		 int age;
		 long personID;
		 long numberPhone;
		 
		 StatusOfNewCustomer studentOrLecturer;
		 ListOfObject listOfStudent = new ListOfObject();
		 ListOfObject listOfLecture = new ListOfObject();
		 
		 String message = String.format(" Please enter your first name: ");
		 System.out.print(message);
		 firstNameOfPerson = myObj.nextLine();
		 
		 message = String.format(" Please enter your last name: ");
		 System.out.print(message);
		 lastNameOfPerson = myObj.nextLine();
		 		 		 
		 message = String.format(" Please enter your mail: ");
		 System.out.print(message);
		 mail = myObj.nextLine();
		 
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
		 personID = myObj.nextLong();
		 
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
		 Person newPerson = new Student(firstNameOfPerson, lastNameOfPerson, mail, city, address, age, personID, numberPhone,nameOfAccademy, studentOrLecturer);
		 System.out.println(newPerson.toString()); 
		 break;
		 
		case Lecturer:
		 Person newPerson2 = new Lecture(firstNameOfPerson, lastNameOfPerson, mail, city, address, age, personID, numberPhone, nameOfAccademy, studentOrLecturer); 
		 System.out.println(newPerson2.toString());
		 break;    
		
		}
		
		
		 
	}
	
	public static StatusOfNewCustomer StatusOfNewCustomerchoose(int i_StudentOrLecturer) {
			
		StatusOfNewCustomer c = null;
		
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
