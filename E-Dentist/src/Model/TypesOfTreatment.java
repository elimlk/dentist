package Model;

import java.sql.Struct;
import java.util.Arrays;

public class TypesOfTreatment {

    private static TypesOfTreatment instance;
    private static String[] typesArr ;

    private TypesOfTreatment() {
        typesArr = new String[]{"Clean", "TeethWhitening", "denture", "ToothRestoration", "Composite", "Amalgam", "SRP", "Crown", "RCT", "Sealing"};
    }

    public static TypesOfTreatment getInstance() {

        if (instance == null) {

            instance = new TypesOfTreatment();

        }

        return instance;
    }

    @Override
    public String toString() {
        String typesList = "{";
        for (int i = 0; i < typesArr.length; i++) {
            typesList += "("+i+")"+typesArr[i]+"  ";
        }
        typesList+="}";
        return typesList;
    }

    public String getType (int index){
        return (typesArr[index]);
    }

    public int getSize()
    {
        int length = typesArr.length;
        return length;
    }
}

