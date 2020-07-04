package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Enums.*;
public class Requirements implements Serializable {

	private static Requirements instance;
	private List<Integer> listOfReq = new ArrayList<Integer>();

	private Requirements() {

		int size = eTypeOfTreatment.SIZE.getIndex();
		for(int i=0;i<size;i++){
			listOfReq.add(0);
		}
	}


	public static Requirements getInstance() {
		if (instance == null)
			return new Requirements();
		else
			return instance;
		
	}
	
	public void updateReq(int i,int value){
		listOfReq.set(i,value);
	}

	public void updateAllReq(List<Integer> l ){
		for(int i=0;i<listOfReq.size();i++)
		{
			listOfReq.set(i,l.get(i));
		}
	}

	public int getReq(int index){
		return listOfReq.get(index);
	}
}
