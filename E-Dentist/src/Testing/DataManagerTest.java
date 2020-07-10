package Testing;

import Model.DataManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataManagerTest {

    @Test
    void getInstance() {
        DataManager instance1 = DataManager.getInstance();
        DataManager instance2 = DataManager.getInstance();
        assertSame(instance1,instance2);
    }
}