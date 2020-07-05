package Model;

public class Patient extends Person {

	private TreatmentFile m_treatmentFile;
	
	public Patient(String i_FirstName, String i_LastName, String i_ID , String i_NumberPhone, String i_Email) {
		super(i_FirstName,i_LastName,i_ID,i_NumberPhone,i_Email);
	}

	public TreatmentFile getM_treatmentFile() {
		return m_treatmentFile;
	}
}
