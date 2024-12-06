import org.example.vncpit252.Controller;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerTest {
    final Controller con = new Controller();

    @Test
    void fxmlDontExist() {
        assertThrows(IllegalStateException.class, () ->{
            con.switchWithNoEvent("random.fxml");
        });
    }

}
