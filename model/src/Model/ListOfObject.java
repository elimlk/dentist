package Model;

import java.util.*;

public class ListOfObject {
	
	
	private List<Student> m_ListOfStudent = new ArrayList<Student>();
	private List<Lecturer> m_ListOfLecturer = new ArrayList<Lecturer>();
	private HashMap<String, Long> m_ListOfTreatment = new HashMap<String, Long>();
	private HashMap<String, String> m_ListOfSystem;
	

	public ListOfObject() {

		m_ListOfSystem = new HashMap<String, String>();
		
	}
	
	public List<Student> getListOfStudent() 
	{
		
		return m_ListOfStudent;
		
	}
	
	public void SetListOfStudent(List<Student> i_ListOfStudent)
	{
		
		this.m_ListOfStudent = i_ListOfStudent;
		
	}
			
	//public HashMap<String, String> getM_ListOfPerson() {
	//	return m_ListOfPerson;
	//}

//	public void setM_ListOfPerson(HashMap<String, String> m_ListOfPerson) {
	//	this.m_ListOfPerson = m_ListOfPerson;
	//}

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
	
	public void AddLecturer(Lecturer i_Lecture)
	{
		m_ListOfLecturer.add(i_Lecture);
	}
	
	public void AddPerson(Person i_Pesron)
	{
		
		boolean checkPerson;
		
		if(i_Pesron == null) {
			
			
			System.out.print(false);
			
		}
		
		checkPerson =  m_ListOfSystem.containsKey(i_Pesron.GetM_Mail()) ||
				       m_ListOfSystem.containsKey(i_Pesron.GetM_ID()); 
		
		if(!checkPerson) {
			
			m_ListOfSystem.put(i_Pesron.GetM_ID(), i_Pesron.GetM_Mail());
			
		}
		else {
			
			System.out.print(false);
			
		}
		
	}


}
