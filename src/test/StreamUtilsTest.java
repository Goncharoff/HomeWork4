import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.Test;

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
  public void testTask04() {
    LongStream result = StreamUtils.linearCongruentialGenerator(137L, 6, 17, 149);
    final String expected = "[137, 94, 134, 76, 26, 24, 12, 89, 104, 45]";
    assertEquals(expected, result.limit(10).boxed().collect(Collectors.toList()).toString());
  }

  @Test
  public void testTask05() {
    assertEquals(Arrays.asList("1", "2", "3", "4", "5", "6"),
            StreamUtils.getElementsFromBothStreams(Stream.of("1", "3", "5"), Stream.of("2", "4", "6")));
  }
}
