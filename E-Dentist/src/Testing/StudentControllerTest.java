package Testing;

import Controller.MainController;
import Controller.StudentController;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class StudentControllerTest 
{

    private DataManager m_Data;
    private  Instructor m_Instructor;
    private Student m_Student;
    private StudentController m_StudentController;
    private MainController m_MainController;
    private  Treatment m_Treatment;

    @Before
    public void setUp() throws IOException
    {
    	
        m_Data  = DataManager.getInstance();
        m_MainController = new MainController();
        m_Instructor= new Instructor("Daddy","Daddon","123123123","0541231230","Daddy@gmail,com","Daddy121212");
        m_Student = new Student("Lior","Kricheli", "203382494", "0545347723", "Lior@gmail.com","Lior121212");
        m_Student.addPatient("123456789","Abba","Mazgano","0541121212","Abba@gmail.com");
        m_StudentController = new StudentController(m_Student);
        m_Data.addInstructor(m_Instructor);
        m_Data.addStudent(m_Student);
        m_Treatment  = new Treatment("New patient","203382494","123123123",1,m_Student.findPatient("123456789"));


    }

    @Test
    public void testCreateNewPatient() throws IOException
    {

        Assertions.assertTrue(m_StudentController.createNewPatient("987654321", "Asaf", "Malka", "0545347712", "Asaf@gmail.com"));
        Assertions.assertTrue(m_StudentController.createNewPatient("987654321", "", "", "1", "Asaf@gmail.com"));
        Assertions.assertFalse(m_StudentController.createNewPatient("987654321", "Asaf", "Malka", "0545347712", "Asaf@gmailcom"));
        Assertions.assertFalse(m_StudentController.createNewPatient("98765432", "Asaf", "Malka", "0545347712", "Asaf@gmailcom"));
        Assertions.assertFalse(m_StudentController.createNewPatient("", "", "", "", ""));

    }

    @Test
    public void testFindPatient() throws IOException
    {

        m_StudentController.createNewPatient("123456789","Avi","Cohen","0545347723","Avi@Gmail.com");

        Assertions.assertTrue(m_StudentController.findPatient("123456789"));
        Assertions.assertFalse(m_StudentController.findPatient("12345678"));

        Assertions.assertNotNull(m_Student.findPatient("123456789"));
        Assertions.assertNull(m_Student.findPatient("12345678"));

    }

    @Test
    public void testAddTreatment() throws IOException
    {

        Assertions.assertEquals(false,m_StudentController.addTreatment("new ptient","111111111","3","123456789"), "Instructor is not exsits");
        Assertions.assertEquals(false,m_StudentController.addTreatment("new ptient","111111111","","123456789"), "type treatment  is not valid");
        Assertions.assertEquals(false,m_StudentController.addTreatment("new ptient","111111111","","123456789"), "type treatment  is not valid");
        Assertions.assertEquals(true,m_StudentController.addTreatment("new ptient","123123123","1","123456789"));

    }

    @Test
    public void testDeleteTreatment(){

        m_Student.addTreatment("123456789", m_Treatment);
        Assertions.assertTrue(m_StudentController.deleteTreatment("123456789","0"),"Not null and the treatment deleted");
        Assertions.assertFalse(m_StudentController.deleteTreatment("123456789","1"),"Null and the treatment its not exsits");

    }

}
