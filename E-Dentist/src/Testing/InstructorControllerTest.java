package Testing;

import Controller.InstructorController;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructorControllerTest {

    private DataManager m_Data;
    private Student m_Student;
    private Instructor m_Instructor;
    private Patient m_Patient;
    private InstructorController m_InstructorConstroller;
    private TreatmentFile m_TreatmentFile;

    @Before
    public void setUp() throws IOException
    {

        m_Data = DataManager.getInstance();
        m_TreatmentFile = new TreatmentFile();
        m_Instructor = new Instructor("Gabi","Omer","204344626","054531111","Gabi@gmail.com","Gabi121212");
        m_InstructorConstroller = new InstructorController(m_Instructor);
        m_Patient =  new Patient("Koral","Kochavi","000000000","0545347723","Koral@gmail.com");
        m_Data.addPatient(m_Patient);
        m_Student =  new Student("Itamar","Yacobi","203311223","051111111","Itamar@gmail.com","Itamar121212");
        m_Data.addStudent(m_Student);

    }

    @Test
    public void testChangeRequirement()
    {

        String messageFailed = m_InstructorConstroller.changeRequirement("a","1");

        Assertions.assertEquals("invalid type code or value incorrect",m_InstructorConstroller.changeRequirement("a","1"),"The value type code is not valid");
        Assertions.assertFalse("invalid type o value incorrect".equals(messageFailed));
        Assertions.assertEquals("invalid type code or value incorrect",m_InstructorConstroller.changeRequirement("2",""),"The value type code for change its not valid");
        Assertions.assertEquals("invalid type code or value incorrect",m_InstructorConstroller.changeRequirement("2","-2"),"The type code for change its Negative");
        Assertions.assertEquals("invalid type code or value incorrect",m_InstructorConstroller.changeRequirement("-29","2"),"The value type code its Negative");

    }

    @Test
    public void teestShowStudentStatus()
    {

        Assertions.assertNull(m_InstructorConstroller.showStudentStatus("111111111"));
        Assertions.assertNotNull(m_InstructorConstroller.showStudentStatus("203311223"));

    }

    @Test
    public void testFindPatientFile()
    {

        Assertions.assertEquals("Patient not found!", m_InstructorConstroller.findPatientFile("1"));
        Assertions.assertEquals( m_TreatmentFile.toString(), m_InstructorConstroller.findPatientFile("000000000"));

    }

}
