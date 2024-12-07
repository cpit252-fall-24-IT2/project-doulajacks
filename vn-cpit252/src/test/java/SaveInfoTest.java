
import org.example.vncpit252.SaveInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveInfoTest {

    private final SaveInfo.SaveInfoBuilder builder = new SaveInfo.SaveInfoBuilder("", "");

    @Test
    void interestNotInitializedEqualsNull() {
        assertEquals(builder, builder.withIntrest(null));
    }

}
