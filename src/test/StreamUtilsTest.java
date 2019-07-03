import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class StreamUtilsTest {
    @Test
    public void testTask01() {
        assertEquals("1. Ivan, 3. Arnold, 5. Robert, 7. Dakota, 9. Mike, 11. Leonid",
                StreamUtils.numberdNamesUtil(Arrays.asList("Ivan", "Arnold", "Robert", "Dakota", "Mike", "Leonid")));
    }

    @Test
    public void testTask02() {
        assertEquals(Arrays.asList("HELLO", "IS", "MY", "NAME", "WORLD"),
                StreamUtils.sortAndUppercase(Arrays.asList("hELLo", "worlD", "mY", "Name", "Is")));
    }

    @Test
    public void testTask03() {
        assertEquals(Arrays.asList("1", "2", "0", "4", "5"),
                StreamUtils.collectElements(Arrays.asList("1, 2, 0", "4, 5")));
    }

    @Test
    public void testTask05() {assertEquals(Arrays.asList("1", "2", "3", "4", "5", "6"),
            StreamUtils.getElementsFromBothStreams(Stream.of("1", "3", "5"), Stream.of("2", "4", "6")));}
}
