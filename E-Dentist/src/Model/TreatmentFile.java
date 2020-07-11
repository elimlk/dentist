package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreatmentFile implements Serializable
{

	private List<Treatment> m_Treatments ;
	
	public TreatmentFile() 
	{
		
		m_Treatments = new ArrayList<Treatment>();
	
	}

	@Override
	public String toString() 
	{
		
		String stringTreatments = "";
		
		for (int i = 0; i < m_Treatments.size(); i++)
		{
		
			stringTreatments = stringTreatments.concat("Treatment (" + i + ") " + m_Treatments.get(i).toString() + "\n");
		
		}

		return stringTreatments;
		
	}

	public void addTreatment(Treatment treatment)
	{
		
		m_Treatments.add(treatment);
		
	}

	public Treatment getTreatment(int treatmentIndex) 
	{
		
		if(treatmentIndex >= 0 && treatmentIndex < m_Treatments.size()) 
		{
		
			return m_Treatments.get(treatmentIndex);
		
		}
		
		return null;
	
	}

	public void deleteTreatment(int treatmentIndex) 
	{
		
		m_Treatments.remove(treatmentIndex);
		
	}

	public boolean completeTreatment(Treatment treatment)
	{
		
		return (treatment.complete());
		
	}

	public String showInCompleteTreatments() 
	{
		
		String stringIncompleteTreatments = "";

		for (int i = 0; i < m_Treatments.size(); i++)
		{
			
			if(m_Treatments.get(i).getStatus() == false) 
			{
			
				stringIncompleteTreatments = stringIncompleteTreatments.concat("Treatment (" + i + ") " + m_Treatments.get(i).toString() + "\n");
			
			}
		
		}

		return stringIncompleteTreatments;

	}
	
}
