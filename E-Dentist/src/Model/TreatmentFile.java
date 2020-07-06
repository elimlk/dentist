package Model;

import java.util.ArrayList;
import java.util.List;

public class TreatmentFile // add observer
{

	private List<Treatment> m_Treatments ;
	
	
	public TreatmentFile() {
		m_Treatments = new ArrayList<Treatment>();
		m_Treatments.add(new Treatment("iiiii","eli","ith",0));
	}

	@Override
	public String toString() {
		String stringTreatments;
		stringTreatments =  "TreatmentFile";
		for (int i=0; i < m_Treatments.size();i++) {
			stringTreatments = stringTreatments.concat(
					"Treatment "+i+" =" + m_Treatments.get(i).toString() +
					'}');
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
