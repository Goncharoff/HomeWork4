import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamUtils {

  public static String numberdNamesUtil(List<String> names) {
    return IntStream.range(0, names.size())
            .mapToObj(indx -> (indx * 2 + 1) + ". " + names.get(indx))
            .collect(Collectors.joining(", "));
  }

  public static List<String> sortAndUppercase(List<String> input) {
    return input.stream()
            .map(String::toUpperCase)
            .peek(System.out::println)
            .sorted()
            .collect(Collectors.toList());
  }

  public static List<String> collectElements(List<String> input) {
    return input.stream()
            .flatMap(str -> Arrays.stream(str.split(" ,")))
            .collect(Collectors.toList());

  }

  public static LongStream linearCongruentialGenerator(Long seed, long a, int c, long m) {
    return LongStream.iterate(seed, i -> (a * i + c) % m);
  }

  public static <T> List<T> getElementsFromBothStreams(Stream<T> firstStream, Stream<T> secondStream) {
    Spliterator<T> firstStreamIterator = firstStream.spliterator();
    Spliterator<T> secondStreamIterator = secondStream.spliterator();

    long minSize = Math.min(firstStreamIterator.estimateSize(), secondStreamIterator.estimateSize());
    List<T> result = new ArrayList<>();


    LongStream.range(0, minSize).forEach(s -> {
      firstStreamIterator.tryAdvance(result::add);
      secondStreamIterator.tryAdvance(result::add);
    });

    return result;
  }

  public static <T> List<T> collectStreamsData(Stream<T> firstStream, Stream<T> secondStream) {
    return Stream.concat(firstStream, secondStream).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    getElementsFromBothStreams(Stream.of("1", "3", "5"), Stream.of("2", "4", "6"));
  }
}
