import javafx.event.ActionEvent;
import org.example.vncpit252.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerTest {
    final Controller con = new Controller();

    @Test
    void FXMLDontExist() {
        assertThrows(IllegalStateException.class, () ->{
            con.switchWithNoEvent("random.fxml");
        });
    }

    @Test
    void wrongEventPassedToResourceSwitch() {
        ActionEvent event = new ActionEvent();
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            con.switchToLearningResources(event);
        });
    }

    @Test
    void emptyEventPassedToSwitchScene() {
        ActionEvent event = new ActionEvent();
        assertThrows(ExceptionInInitializerError.class, () -> {
            con.switchScene(event, "load_home_page.fxml");
        });
    }

    @Test
    void emptyEventAndInvalidFXMLPassedToSwitchScene() {
        ActionEvent event = new ActionEvent();
        assertThrows(IllegalStateException.class, () -> {
            con.switchScene(event, "random.fxml");
        });
    }

}
