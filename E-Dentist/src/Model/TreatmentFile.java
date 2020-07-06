package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreatmentFile implements Serializable// add observer
{

	private List<Treatment> m_Treatments ;
	
	
	public TreatmentFile() {
		
		m_Treatments = new ArrayList<Treatment>();
		m_Treatments.add(new Treatment("clean 21 thoth","eli","ith",0));
	
	}

	@Override
	public String toString() {
		
		String stringTreatments = "";
		
		for (int i = 0; i < m_Treatments.size(); i++)
		{
		
			stringTreatments = stringTreatments.concat("Treatment (" + i + ") " + m_Treatments.get(i).toString() + "\n");
		
		}

		return stringTreatments;
		
	}

	public void StartTreatment(Treatment i_Treatment, long i_IdInstractor) {
		//TODO
	}
	
	public void CreateTreatment() {
		//TODO
		
	}
	
	public void DeleteTreatment(long i_IdTreatment) {
		//TODO
		
	}

}
