package Model;

import java.io.*;
import java.util.*;

public class Files<T> {

	
	private final String m_FileName;
	
	
	public Files(String i_FilaeName) {
		
		this.m_FileName = i_FilaeName;
		
	}
	
	private boolean isFileExists() 
	{
		
		File newFile = new File(m_FileName);
		return newFile.exists();
		
	}
	
	
	//public List<T> read()//throw 
	//{
	
	//if(!isFileExists()) {
		
	//	return new ArrayList<T>();
		
	//}
	
	//try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.m_FileName)))
	//{
	 
	//	return (List<T>) ois.readObject();
		
	//}

//  }

}