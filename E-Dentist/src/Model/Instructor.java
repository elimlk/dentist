package Model;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Instructor extends Person {
     
	private String m_Email;
	private String m_Password;
	private List<Treatment> m_pendingTreatmentList;

	public Instructor(String firstName, String lastName, String iD,
		String numberPhone, String email, String password) 
	{
		
	    super(firstName, lastName ,iD , numberPhone, email);
	    m_Password = password;
	    m_pendingTreatmentList = new ArrayList<Treatment>();
		
	}
	
	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String email) {
		this.m_Email = email;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String password) {
		this.m_Password = password;
	}

	
	public void CheckStatus(String studentID){
		//TODO
		
	}

	public void ChangeRequirments(int typeCode,int value){
		Requirements requirements = Requirements.getInstance();
		requirements.updateRequirement(typeCode,value);
	}

	public String checkUpdates()
	{
		String updatesStr = "Treatments waiting your approval:\n";
		if (m_pendingTreatmentList.size()==0)
			return "No Treatment waiting for approval";
		for(int i =0;i<m_pendingTreatmentList.size();i++){
			updatesStr += "("+i+") "+"Treatment of patianet :"+m_pendingTreatmentList.get(i).toString()+"\n";
		}
		return updatesStr;
	}
	@Override
	public void updateAboutComplete(Treatment treatment) {
		m_pendingTreatmentList.add(treatment);
	}

	@Override
	public void updateAboutGrades(Treatment treatment) { } // do nothing

	public boolean aproveTrearment(String userInput,String grade){
		int input = -999;
		int gradeInt = -999;
		DataManager data = DataManager.getInstance();
		try {
			input = Integer.parseInt(userInput);
			gradeInt = Integer.parseInt(grade);
		} catch (NumberFormatException e) {
			return false;
		}

		if(input>=0 && input < m_pendingTreatmentList.size() ){
			if((gradeInt>=0) && (gradeInt<= 100)) {
				String studentID = m_pendingTreatmentList.get(input).getTreatmentBy();
				m_pendingTreatmentList.get(input).setM_Grade(gradeInt);
				data.findStudent(studentID).deleteTreatmentFromWaitinglist(m_pendingTreatmentList.get(input));
				data.findStudent(studentID).addTreatmentToGraded(m_pendingTreatmentList.get(input));
				//data.findStudent(studentID).updateReq(m_pendingTreatmentList.get(input).getM_Type());
				m_pendingTreatmentList.remove(input);
				return true;
			}else if(gradeInt == -1) {
				m_pendingTreatmentList.get(input).setM_treatmentStatus(false);
				m_pendingTreatmentList.remove(input);
			}
		}
		return false;
	}

	public boolean pendingUpdates() {
		return !(m_pendingTreatmentList.size() == 0);
	}
}
