import org.example.vncpit252.Controller;
import org.example.vncpit252.SaveInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SaveInfoTest {

    private final SaveInfo.SaveInfoBuilder builder = new SaveInfo.SaveInfoBuilder("", "");

    @Test
    void interestNotInitializedEqualsNull() {
        assertEquals(builder, builder.withIntrest(null));
    }

}
