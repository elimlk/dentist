package Model;

import Enums.eTypeOfTreatment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentRequirement implements Serializable {

	private List<Integer> m_ListOfRequirement = new ArrayList<Integer>();

	public StudentRequirement()
	{
		
		int size = eTypeOfTreatment.SIZE.getIndex();
		
		for(int i = 0 ;i < size; i++){
		
			m_ListOfRequirement.add(0);
	
		}
	
	}
	
	
	public void incRequirement (int index){
		
		int currentVal = m_ListOfRequirement.get(index);
		
		m_ListOfRequirement.set(index, currentVal++);
		
	}
	
	public int getRequirement(int index){
		
		return m_ListOfRequirement.get(index);
	
	}

}
