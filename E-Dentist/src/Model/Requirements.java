package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Requirements implements Serializable {

	private static Requirements instance;
	private static List<Integer> m_ListOfRequirement;
	private static TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();


	private Requirements() {
		m_ListOfRequirement = new ArrayList<Integer>();
		int size = typesOfTreatment.getSize();
		for(int i=0;i<size;i++) {
			
			m_ListOfRequirement.add(0);
			
		}
		
	}

	@Override
	public String toString() {
		String requiermentsStr;
		requiermentsStr = "Global requirements is: ";
		for(int i=0;i<typesOfTreatment.getSize();i++)
			requiermentsStr += "("+i+")"+ typesOfTreatment.getType(i)+": "+m_ListOfRequirement.get(i)+"  ";
		return requiermentsStr;
	}

	public static Requirements getInstance() {
		
		if (instance == null) {
		
			instance = new Requirements();
		}
			return instance;
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

	public List<Integer> getM_ListOfRequirement() {
		return m_ListOfRequirement;
	}

	public void setM_ListOfRequirement(List<Integer> m_ListOfRequirement) {
		Requirements.m_ListOfRequirement = m_ListOfRequirement;
	}

	protected  Object readResolve(){
		
		return instance;
	
	}


}
