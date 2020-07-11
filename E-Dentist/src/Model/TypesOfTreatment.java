package Model;

import java.io.Serializable;
import java.sql.Struct;
import java.util.Arrays;

public class TypesOfTreatment implements Serializable
{

    private static TypesOfTreatment instance;
    private static String[] s_TypesArray ;

    private TypesOfTreatment() 
    {
    	
        s_TypesArray = new String[]{"Clean", "TeethWhitening", "denture", "ToothRestoration", "Composite", "Amalgam", "SRP", "Crown", "RCT", "Sealing"};
    
    }

    public static TypesOfTreatment getInstance() 
    {

        if (instance == null)
        {

            instance = new TypesOfTreatment();

        }

        return instance;
        
    }

    @Override
    public String toString()
    {
    	
        String typesList = "{";
        
        for (int i = 0; i < s_TypesArray.length; i++)
        {
        	
            typesList += "("+i+")" + s_TypesArray[i] + "  ";
        
        }
        
        typesList += "}";
        
        return typesList;
        
    }

    public String getType (int index)
    {
    	
        return (s_TypesArray[index]);
    
    }

    public int getSize()
    {
    	
        int length = s_TypesArray.length;
        
        return length;
    
    }
    
}

