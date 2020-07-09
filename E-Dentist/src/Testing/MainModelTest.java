package Testing;

import Controller.MainController;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainModelTest {

    @Test
    void register() throws IOException {
        MainController mainController = new MainController();
        boolean regValue = mainController.register("123123123","Itamar","Yacoby","0545934997","ithamar000@gmail.com","1234",false);
        assertTrue(regValue);
        regValue = mainController.register("12123","Itamar","Yacoby","0545934997","ithamar000@gmail.com","1234",false);
        assertFalse(regValue);

    }
}