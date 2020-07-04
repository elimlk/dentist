package Model;

import Enums.eTypeOfTreatment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentRequirement implements Serializable {

	private List<Integer> listOfReq = new ArrayList<Integer>();

	public StudentRequirement() {
		int size = eTypeOfTreatment.SIZE.getIndex();
		for(int i=0;i<size;i++){
			listOfReq.add(0);
		}
	}
	
	
	public void incReq (int index){
		int currentVal = listOfReq.get(index);
		listOfReq.set(index,currentVal++);
	}
	public int getReq(int index){
		return listOfReq.get(index);
	}

}
