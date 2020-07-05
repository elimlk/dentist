package Model;

import java.io.*;
import java.util.*;


public class DataManager
{
	private static DataManager instance;
	private static List<Student> m_ListOfStudents;
	private static List<Instructor> m_ListOfInstructors;
	private static List<Patient> m_ListOfPatients;
	private static Requirements m_Requirements;

	final String studentListFileName = "students_list.ser";
	final String instructorFileName = "instructors_list.ser";
	final String patienntFileName = "patient_list.ser";
	final String requirementsFileName = "requierments.ser";
	
	private DataManager()
	{

		m_ListOfStudents = new ArrayList<Student>();
		m_ListOfInstructors = new ArrayList<Instructor>();
		m_ListOfPatients = new ArrayList<Patient>();
		m_Requirements = m_Requirements.getInstance();



	}

	public void saveData () throws IOException {

		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(studentListFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(m_ListOfStudents);
			oos.close();
			fos.close();

			fos = new FileOutputStream(instructorFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(m_ListOfInstructors);
			oos.close();
			fos.close();

			fos = new FileOutputStream(patienntFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(m_ListOfPatients);
			oos.close();
			fos.close();

			fos = new FileOutputStream(requirementsFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(m_Requirements);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void loadData() throws IOException, ClassNotFoundException {
		FileInputStream fis;
		ObjectInputStream ois;

		try {
			fis = new FileInputStream(studentListFileName);
			ois = new ObjectInputStream(fis);
			m_ListOfStudents = (ArrayList) ois.readObject();
			ois.close();
			fis.close();

			fis = new FileInputStream(instructorFileName);
			ois = new ObjectInputStream(fis);
			m_ListOfInstructors = (ArrayList) ois.readObject();
			ois.close();
			fis.close();

			fis = new FileInputStream(patienntFileName);
			ois = new ObjectInputStream(fis);
			m_ListOfPatients = (ArrayList) ois.readObject();
			ois.close();
			fis.close();

			fis = new FileInputStream(requirementsFileName);
			ois = new ObjectInputStream(fis);
			m_Requirements = (Requirements) ois.readObject();
			ois.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static DataManager getInstance()
	{
		if (instance == null) {
			instance = new DataManager();
		}
		return instance;
	}

	public Patient findPatientInData(String id)
	{
		for(Patient p : m_ListOfPatients){
			if (p.getM_ID().equals(id))
				return p;
		}
		return null;
	}

	public Instructor findInstructor(String id) {
		for(Instructor I : m_ListOfInstructors){
			if (I.getM_ID().equals(id))
				return I;
		}
		return null;
	}
	public Student findStudent(String id){
		for(Student s : m_ListOfStudents){
			if (s.getM_ID().equals(id))
				return s;
		}
		return null;
	}

	public void addInstructor(Instructor newIns) {
		m_ListOfInstructors.add(newIns);
	}

	public void addStudent(Student newStudent) {
		m_ListOfStudents.add(newStudent);
	}




}
