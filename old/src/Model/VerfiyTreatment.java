package Model;

import java.util.*;

public interface VerfiyTreatment {

	Student SearchStudent(String i_IDStudent);
	
	List<Student> Filter(Object i_Studnt);
	
	void Update(Student i_Student);
		
}
