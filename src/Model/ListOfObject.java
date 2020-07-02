package Model;

import java.util.*;

public class ListOfObject 
{

	private List<Student> m_ListOfStudent;
	private List<Lecturer> m_ListOfLecturer;
	private HashMap<String, Long> m_ListOfTreatment;
	private List<Person> m_ListOfSystem;
	
	public ListOfObject()
	{

		m_ListOfSystem = new ArrayList<Person>();
		m_ListOfStudent = new ArrayList<Student>();
		m_ListOfLecturer = new ArrayList<Lecturer>();
		
	}
	
	public List<Student> getListOfStudent() 
	{
		
		return m_ListOfStudent;
		
	}
	
	public void SetListOfStudent(List<Student> i_ListOfStudent)
	{
		
		this.m_ListOfStudent = i_ListOfStudent;
		
	}
			
	public List<Person> getM_ListOfPerson()
	{
		
		return m_ListOfSystem;
	
	}

	public void setM_ListOfPerson(List<Person> i_ListOfPerson) 
	{
		
		this.m_ListOfSystem = i_ListOfPerson;
	
	}

	public HashMap<String, Long> getM_ListOfTreatment() 
	{
	
		return m_ListOfTreatment;
	
	}

	public void setM_ListOfTreatment(HashMap<String, Long> m_ListOfTreatment)
	{
	
		this.m_ListOfTreatment = m_ListOfTreatment;

	}

	public void AddStudent(Student i_Student)
	{
		
		m_ListOfStudent.add(i_Student);
	
	}
	
	public void AddLecturer(Lecturer i_Lecture)
	{
		
		m_ListOfLecturer.add(i_Lecture);
	
	}
	
	public void AddPerson(Person i_Pesron)
	{
		
		boolean checkPerson = true;
		
		if(i_Pesron == null) {
				
			System.out.print(false);
			
		}
		
		for(Person person: m_ListOfSystem)
		{
					
			if(person.GetM_Mail().equals(i_Pesron.GetM_Mail()) ||
				       person.GetM_ID().equals(i_Pesron.GetM_ID())) {
				
				checkPerson = !checkPerson;
				break;
				
			}
			
		}
		
		if(checkPerson) {
			
			m_ListOfSystem.add(i_Pesron);
			
		}
		else {
			
			System.out.print("Not good");
			
		}
		
	}

}
