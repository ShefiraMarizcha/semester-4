import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MaxFinderTest {

    @Test
    public void testFindMaxPositiveNumbers() {
        // Test case 1: a = 1, b = 2, c = 3
        assertEquals(3, MaxFinder.findMax(1, 2, 3));
    }

    @Test
    public void testFindMaxNegativeNumbers() {
        // Test case 2: a = -1, b = -2, c = -3
        assertEquals(-1, MaxFinder.findMax(-1, -2, -3));
    }

    @Test
    public void testFindMaxWithZero() {
        // Test case 3: a = 0, b = 0, c = 1
        assertEquals(1, MaxFinder.findMax(0, 0, 1));
    }
}
