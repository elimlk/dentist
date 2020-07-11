package Model;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;


public class DataManager
{
	
	private static DataManager instance;
	private static List<Student> s_ListOfStudents;
	private static List<Instructor> s_ListOfInstructors;
	private static List<Patient> s_ListOfPatients;
	private static Requirements s_Requirements;
	private static List<Integer> s_listOfRequirements;

	final String studentListFileName = "students_list.ser";
	final String instructorFileName = "instructors_list.ser";
	final String patienntFileName = "patient_list.ser";
	final String requirementsFileName = "requierments.ser";
	String instructorRegisterKey;
	
	private DataManager()
	{

		s_ListOfStudents = new ArrayList<Student>();
		s_ListOfInstructors = new ArrayList<Instructor>();
		s_ListOfPatients = new ArrayList<Patient>();
		s_listOfRequirements = new ArrayList<Integer>();
		s_Requirements = Requirements.getInstance();
		instructorRegisterKey = "1234";

	}

	public void saveData () throws IOException
	{

		FileOutputStream fos;
		ObjectOutputStream oos;

		try 
		{
			
			fos = new FileOutputStream(studentListFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s_ListOfStudents);
			oos.close();
			fos.close();

			fos = new FileOutputStream(instructorFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s_ListOfInstructors);
			oos.close();
			fos.close();

			fos = new FileOutputStream(patienntFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s_ListOfPatients);
			oos.close();
			fos.close();

			s_listOfRequirements = Requirements.getInstance().getM_ListOfRequirement();
			fos = new FileOutputStream(requirementsFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s_listOfRequirements);
			oos.close();
			fos.close();
			
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
			
		}

	}

	public void loadData() throws IOException, ClassNotFoundException 
	{
		
		FileInputStream fis;
		ObjectInputStream ois;

		try 
		{
			
			fis = new FileInputStream(studentListFileName);
			ois = new ObjectInputStream(fis);
			s_ListOfStudents = (ArrayList) ois.readObject();
			ois.close();
			fis.close();

			fis = new FileInputStream(instructorFileName);
			ois = new ObjectInputStream(fis);
			s_ListOfInstructors = (ArrayList) ois.readObject();
			ois.close();
			fis.close();

			fis = new FileInputStream(patienntFileName);
			ois = new ObjectInputStream(fis);
			s_ListOfPatients = (ArrayList) ois.readObject();
			ois.close();
			fis.close();

			fis = new FileInputStream(requirementsFileName);
			ois = new ObjectInputStream(fis);
			s_listOfRequirements = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			Requirements.getInstance().setM_ListOfRequirement(s_listOfRequirements);

		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		
		}
				
	}
	
	public String getRegisterKey()
	{
		
		return instructorRegisterKey;
	
	}
	
	public static DataManager getInstance()
	{
		
		if (instance == null)
		{
		
			instance = new DataManager();
		
		}
		
		return instance;
	
	}

	public Patient findPatientInData(String id)
	{
		
		for(Patient person : s_ListOfPatients)
		{
			
			if (person.getM_ID().equals(id)) 
			{
				
				return person;
				
			}
			
		}
		
		return null;
		
	}

	public Instructor findInstructor(String id) 
	{
		
		for(Instructor Instructor : s_ListOfInstructors)
		{
			
			if (Instructor.getM_ID().equals(id)) 
			{
				
				return Instructor;
		
			}
		
		}
		
		return null;
		
	}
	
	public Student findStudent(String id)
	{
		
		for(Student student : s_ListOfStudents)
		{
		
			if (student.getM_ID().equals(id)) 
			{
			
				return student;
			
			}
			
		}
					
		return null;
		
	}

	public void addInstructor(Instructor newInstructor) throws IOException 
	{
		
		s_ListOfInstructors.add(newInstructor);
		saveData();
	
	}

	public void addStudent(Student newStudent) throws IOException
	{
		
		s_ListOfStudents.add(newStudent);
		saveData();
		
	}

	public void addPatient(Patient patient) throws IOException 
	{

		s_ListOfPatients.add(patient);
		saveData(); 
		
	}

	public boolean checkValidity(String id, String firstName, String lastName, String phone, String email)
	{
		
		boolean isNotValid = true;
        		
		try 
		{
			
			 Integer.parseInt(id);
			 Integer.parseInt(phone);
			
		}
		catch (NumberFormatException e) 
		{
			
			return false;
			
		}
		
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);

		if (id.length() != 9 || (pattern.matcher(email).matches() == false)) 
		{

			isNotValid = !isNotValid;

		}
			
		return isNotValid;

	}
	
}
