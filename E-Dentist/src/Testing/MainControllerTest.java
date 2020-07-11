package Testing;

import Controller.MainController;
import Model.DataManager;
import Model.Instructor;
import Model.Person;
import Model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.Scanner;

public class MainControllerTest
{

    private Person m_Person;
    private Person m_Person1;
    private MainController m_MainController;
    private DataManager m_Data;

    @Before
    public void setUp() throws IOException
    {

        m_Data = DataManager.getInstance();
        m_MainController = new MainController();
        m_Person = new Student("Lior","kricheli", "203382494","0545347723", "Lior@gmail.com", "lior121212" );
        m_Person1 = new Instructor("Gabi","Omer", "204344626","0545347732", "gabi@gmail.com", "gabi121212" );
        m_Data.addStudent((Student)m_Person);

    }

    @Test
    public void testLogin()
    {

        Assertions.assertNotNull(m_Person);
        Assertions.assertTrue(m_Person instanceof Student);
        Assertions.assertFalse(m_Person1 instanceof Student);

    }

    @Test
    public void testRegister() throws IOException
    {

        Assertions.assertEquals(true, m_MainController.register("203333333", "Eliran", "Malka", "0545341111", "Eliran@gmail.com", "eliran121212", true));
        Assertions.assertEquals(true, m_MainController.register("202222222", "Itamar", "yacobi", "0545341112", "itamar@gmail.com", "itamar121212", false));
        Assertions.assertEquals(false, m_MainController.register("", "Eliran", "Malka", "0545341111", "Eliran@gmail.com", "eliran121212", true));
        Assertions.assertEquals(false, m_MainController.register("203333333", "Eliran", "Malka", "0545341111", "", "eliran121212", true));

    }

    @Test
    public void testcheckLogin()
    {

        try {

            Assertions.assertTrue(m_MainController.checkLogin("123456789"));
            Assertions.assertFalse(m_MainController.checkLogin("1234abcde"));
            m_MainController.checkLogin("Lior12345678");

        }
        catch (IllegalArgumentException e)
        {

            Assertions.assertEquals("User or Password is not correct", e.getMessage());

        }

    }

}