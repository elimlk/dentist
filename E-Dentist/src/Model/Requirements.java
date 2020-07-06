package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Enums.*;
public class Requirements implements Serializable {

	private static Requirements instance;
	private List<Integer> m_ListOfRequirement = new ArrayList<Integer>();

	private Requirements() {

		int size = eTypeOfTreatment.SIZE.getIndex();
		
		for(int i=0;i<size;i++) {
			
			m_ListOfRequirement.add(0);
			
		}
		
	}


	public static Requirements getInstance() {
		
		if (instance == null) {
		
			return new Requirements();
		}
		else {
			
			return instance;
		}
		
	}
	
	public void updateRequirement(int index,int value){
		
		m_ListOfRequirement.set(index,value);
		
	}

	public void updateAllRequirement(List<Integer> listOfRequirement)
	{
		
		for(int i = 0; i < listOfRequirement.size(); i++)
		{
			
			listOfRequirement.set(i,listOfRequirement.get(i));
		
		}
		
	}

	public int getReq(int index){
		
		return m_ListOfRequirement.get(index);
	}

	public Object readResolve(){
		
		return getInstance();
	
	}

}
