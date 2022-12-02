import com.javatpoint.controller.HelloWorldController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class controllerTest {

    @Test
    public void generatePassayPasswordTest() {
        List<String> passwordList = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            String password = HelloWorldController.generatePassayPassword(20);
            passwordList.add(password);
        }

        for (int i = 0; i < passwordList.size(); i++) {
            assertTrue(passwordList.get(i).length() == 20);
        }
    }
}
