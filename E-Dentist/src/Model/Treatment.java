package Model;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.text.*;
import java.time.*;
import java.time.format.*;
import Enums.*;

public class Treatment implements Serializable {

	private String m_Description;
	private String m_TreatmentBy;
	private String m_ValidatedBy;
	private String m_Type;
	private int m_Grade;
	private boolean m_treatmentStatus;
	private static TypesOfTreatment type = new TypesOfTreatment();

	
	
	public Treatment(String i_Description,String i_TreatmentBy,String i_ValidatedBy,int i_Type) {
		m_Description = i_Description;
		m_TreatmentBy = i_TreatmentBy;
		m_ValidatedBy = i_ValidatedBy;
		m_Type = type.typesArr[i_Type];
		m_treatmentStatus =false;
		m_Grade = -1;

	}

	@Override
	public String toString() {
		String gradeStr;
		String statusStr;
		if (m_Grade == -1)
			gradeStr = "Pending";
		else
			gradeStr = Integer.toString(m_Grade);
		if(m_treatmentStatus == true)
			statusStr = "COMPLETED";
		else
			statusStr = "PENDING";
			return "{" +
					"Description='" + m_Description + '\'' +
					",Treated By='" + m_TreatmentBy + '\'' +
					", Validated By='" + m_ValidatedBy + '\'' +
					", Type='" +m_Type + '\''+
					", Grade ='" +gradeStr + '\'' +
					", Treatment status ='" + statusStr +'\''+'}';
	}

	public void setM_Grade(int m_Grade) {
		this.m_Grade = m_Grade;
	}
}







	

	
	
	
	

