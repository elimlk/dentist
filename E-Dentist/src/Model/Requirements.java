package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Requirements implements Serializable
{

	private static Requirements instance;
	private static List<Integer> s_ListOfRequirement;
	private static TypesOfTreatment typesOfTreatment = TypesOfTreatment.getInstance();

	private Requirements()
	{
		
		s_ListOfRequirement = new ArrayList<Integer>();
		int size = typesOfTreatment.getSize();
		
		for(int i=0; i < size; i++) 
		{
			
			s_ListOfRequirement.add(0);
			
		}
		
	}

	@Override
	public String toString()
	{
		
		String requiermentsStr;
		requiermentsStr = "Global requirements is: ";
		
		for(int i = 0; i < typesOfTreatment.getSize(); i++)
		
			requiermentsStr += "("+i+")" + typesOfTreatment.getType(i) + ": " + s_ListOfRequirement.get(i) + "  ";
		
		return requiermentsStr;
	
	}
	
	protected  Object readResolve()
	{
		
		return instance;
	
	}

	public static Requirements getInstance()
	{
		
		if (instance == null) 
		{
		
			instance = new Requirements();
			
		}
		
			return instance;
			
	}
	
	public void updateRequirement(int index, int value)
	{
		
		s_ListOfRequirement.set(index, value);
		
	}

	public void updateAllRequirement(List<Integer> listOfRequirement)
	{
		
		for(int i = 0; i < listOfRequirement.size(); i++)
		{
			
			listOfRequirement.set(i, listOfRequirement.get(i));
		
		}
		
	}

	public int getRequirement(int index)
	{
		
		return s_ListOfRequirement.get(index);
		
	}

	public List<Integer> getM_ListOfRequirement() 
	{
		
		return s_ListOfRequirement;
		
	}

	public void setM_ListOfRequirement(List<Integer> listOfRequirement)
	{
		
		Requirements.s_ListOfRequirement = listOfRequirement;
		
	}

}
