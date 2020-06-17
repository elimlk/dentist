package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class Treatment {
  		
		private String m_DescriptonOfTreatment;	
		private LocalDateTime m_DateTime;
		private int m_IDTreatmner;
		
		private HashMap<Integer, Integer> m_ListOfTreatment = new HashMap<Integer, Integer>();
		 
		public Treatment() {}
		
		public Treatment(String i_DescriptionOfTreatment) 
		{
						
			m_DateTime = LocalDateTime.now();		
			m_DescriptonOfTreatment = i_DescriptionOfTreatment;		   
		    m_IDTreatmner = ThreadLocalRandom.current().nextInt(99999999, 1000000000);// ID random of treatment
		    
		}
			
		public String getM_DescriptonOfTreatment() {
			return m_DescriptonOfTreatment;
		}

		public void setM_DescriptonOfTreatment(String m_DescriptonOfTreatment) {
			this.m_DescriptonOfTreatment = m_DescriptonOfTreatment;
		}
		
		public HashMap<Integer, Integer> getM_ListOfTreatment() {
			return m_ListOfTreatment;
		}

		public void setM_ListOfTreatment(HashMap<Integer, Integer> m_ListOfTreatment) {
			this.m_ListOfTreatment = m_ListOfTreatment;
		}

		public LocalDateTime getM_DateTime() {
			return m_DateTime;
		}
		
		public void AddTreatmentToList() 
		{
					
			m_ListOfTreatment.put(m_IDTreatmner, m_IDTreatmner);
					
		}
		
		public void DisplayTreatment(String i_FirstName, long i_ID) {
			
			//if(m_ListOfTreatmrnt.getM_ListOfTreatment() == null) {
				
				
				  //throw new Exception();
				
		//	}
			
			//  for(long customer :  ){
				   
				//   if()
				   
			  // }
			
			
		}

		@Override
		public String toString() {
			
		  String message = String.format( 
			   "\nDescription: " + m_DescriptonOfTreatment);
		  
		  return message;
			
		}
	
}







	

	
	
	
	

