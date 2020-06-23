package Ob_Doctor;

import java.util.HashMap;

public class Login 
{

	
	private String m_UserName;
	private String m_Password;
	public HashMap<String, String> m_ListOfsystem = new HashMap<String,String>();//user name and password
	
	public Login(String i_UserName, String i_Password) {
	
    if(this.m_ListOfsystem.containsKey(i_UserName) == true && this.m_ListOfsystem.containsKey(i_Password) == true){
	
	this.setM_UserName(i_UserName);
	this.setM_Password(i_Password);
    
    }
    else 
    {
    	    System.out.println("ERROR! Try again");
    }
	
	}

	public String getM_UserName() {
		return m_UserName;
	}

	public void setM_UserName(String m_UserName) {
		this.m_UserName = m_UserName;
	}

	public String getM_Password() {
		return m_Password;
	}

	public void setM_Password(String m_Password) {
		this.m_Password = m_Password;
	}
	
	
	

}
