package Model;

public class Patient extends Person {

	private TreatmentFile m_treatmentFile;
	
	public Patient(String firstName, String lastName, String id , String numberPhone, String email) {
		
		super(firstName, lastName, id, numberPhone, email);
		m_treatmentFile = new TreatmentFile();
	
	}

	public TreatmentFile getM_treatmentFile() {
		
		return m_treatmentFile;
	
	}
	
}
