package Testing;

import Controller.MainController;
import Model.Instructor;
import Model.Person;
import Model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class MainControllerTest {

    private Person m_Person;
    private Person m_Person1;
    private MainController m_MainController;

    @Before
    public void setUp() {

        m_MainController = new MainController();
        m_Person = new Student("lior", "kricheli", "203382494", "0545347723", "Lior@gmail.com", "Lior121212");
        m_Person1 = new Instructor("Gabi", "Omer", "204344626", "0545347732", "Gabi@gmail.com", "Gabi121212");

    }

    @Test
    public void testStudentCheckLoginPasswordIsNotValid() {

        try {

            m_MainController.login("203382494", "lior12121");

        } catch (IllegalArgumentException e) {

            Assertions.assertEquals("User or Password is not correct", e.getMessage());

        }
    }

    @Test
    public void testStudentCheckLoginIdIsNotValid() {

        try {

            m_MainController.login("20338249", "lior121212");

        } catch (IllegalArgumentException e) {

            Assertions.assertEquals("User or Password is not correct", e.getMessage());

        }
    }

    @Test
    public void testInstructorCheckLoginPasswordIsNotValid() {

        try {

            m_MainController.login("204344626", "Gabi12121");

        } catch (IllegalArgumentException e) {

            Assertions.assertEquals("User or Password is not correct", e.getMessage());

        }

    }

    @Test
    public void testInstructortCheckLoginIdIsNotValid() {

        try {

            m_MainController.login("20434462", "Gabi121212");

        } catch (IllegalArgumentException e) {

            Assertions.assertEquals("User or Password is not correct", e.getMessage());

        }

    }

    @Test
    public void testRegister() throws IOException {

        try {
            Assertions.assertEquals(true, m_MainController.register("203333333", "Eliran", "Malka", "0545341111", "Eliran@gmail.com", "eliran121212", true));
            Assertions.assertEquals(false, m_MainController.register("", "Eliran", "Malka", "0545341111", "Eliran@gmail.com", "eliran121212", true));
            Assertions.assertEquals(false, m_MainController.register("203333333", "Eliran", "Malka", "0545341111", "", "eliran121212", true));
        } catch (IOException e) {

            System.out.println(e);
        }
    }

    @Test
    public void testcheckLogin() {

        try {

            //Assertions.assertNotNull(m_MainController.login("123456789", "123456"));
            Assertions.assertNull(m_MainController.login("123456789", "12345"));
            Assertions.assertNull(m_MainController.login("123456789", "123456"));

        }
        catch (IllegalArgumentException e){

            Assertions.assertEquals("User or Password is not correct", e.getMessage());

        }
    }
}