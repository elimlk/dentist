package Model;

import java.util.*;

public class ListOfObject {
	
	
	private List<Student> m_ListOfStudent = new ArrayList<Student>();
	private List<Lecture> m_ListOfLecture = new ArrayList<Lecture>();
	private HashMap<String, Long> m_ListOfTreatment = new HashMap<String, Long>();
	private List<Person> m_ListOfPerson = new ArrayList<Person>();
	

	public ListOfObject() {

	}
	
	public List<Student> getListOfStudent() 
	{
		
		return m_ListOfStudent;
		
	}
	
	public void SetListOfStudent(List<Student> i_ListOfStudent)
	{
		
		this.m_ListOfStudent = i_ListOfStudent;
		
	}
			
	public List<Person> getM_ListOfPerson() {
		return m_ListOfPerson;
	}

	public void setM_ListOfPerson(List<Person> m_ListOfPerson) {
		this.m_ListOfPerson = m_ListOfPerson;
	}

	public HashMap<String, Long> getM_ListOfTreatment() {
		return m_ListOfTreatment;
	}

	public void setM_ListOfTreatment(HashMap<String, Long> m_ListOfTreatment) {
		this.m_ListOfTreatment = m_ListOfTreatment;
	}



	


	public void AddStudent(Student i_Student)
	{
		m_ListOfStudent.add(i_Student);
	}
	
	public void AddLecturer(Lecture i_Lecture)
	{
		m_ListOfLecture.add(i_Lecture);
	}
	
	public void AddPerson(Person i_Pesron)
	{
		m_ListOfPerson.add(i_Pesron);
	}


}
