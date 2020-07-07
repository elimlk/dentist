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
	private static TypesOfTreatment type = new TypesOfTreatment();

	
	
	public Treatment(String i_Description,String i_TreatmentBy,String i_ValidatedBy,int i_Type) {
		
		m_Description = i_Description;
		m_TreatmentBy = i_TreatmentBy;
		m_ValidatedBy = i_ValidatedBy;
		m_Type = type.typesArr[i_Type];
		m_Grade = -1;

	}

	@Override
	public String toString() {

		if (m_Grade == -1)
		{
			return "{" +
					"Description='" + m_Description + '\'' +
					",Treated By='" + m_TreatmentBy + '\'' +
					", Validated By='" + m_ValidatedBy + '\'' +
					", Type='" +m_Type + '\''+
					", Grade = pending" +
					'}';
		}
		else {
			
			return "Treatment{" +
					"Description='" + m_Description + '\'' +
					",Treated By='" + m_TreatmentBy + '\'' +
					", Validated By='" + m_ValidatedBy + '\'' +
					", Type=" +m_Type + '\''+
					", Grade=" + m_Grade +
					'}';
		}
	}

	public void setM_Grade(int m_Grade) {
		this.m_Grade = m_Grade;
	}
}







	

	
	
	
	

