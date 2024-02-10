import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Simple test method to verify all tools are working properly.
 */
public class MainTest {

    @BeforeAll
    static void setup() {
        // Set conditions before all tests run
    }

    @BeforeEach
    void individualSetup() {
        // Set conditions before each test is run
    }

    @Test
    void testMain() {
        assertEquals(0, Main.level, "Level was not 0");
    }

}
