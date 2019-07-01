import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamUtils {

  public static String numberdNamesUtil(List<String> names) {
    return IntStream.range(0, names.size())
            .mapToObj(indx -> (indx * 2 + 1) + "." + names.get(indx))
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

  //TODO Why there is 4 params in test?
  public static LongStream linearCongruentialGenerator(Long seed) {
    long a = 25214903917L;
    int c = 11;
    long m = (long) Math.pow(2, 48);

    return LongStream.iterate(seed, i -> (a * i + c) % m);

  }

  //TODO some kind of ...
  public static <T> List<T> getElementsFromBothStreams(Stream<T> firstStream, Stream<T> secondStream) {

    List<T> firstStreamAsList = firstStream.collect(Collectors.toList());
    List<T> secondStreamAsList = secondStream.collect(Collectors.toList());
    int minSize = Math.min(firstStreamAsList.size(), secondStreamAsList.size());
    List<T> result = new ArrayList<>(minSize);

    IntStream.range(0, minSize).forEach(it -> {
      result.add(firstStreamAsList.get(it));
      result.add(secondStreamAsList.get(it));
    });

    return result;
  }

  public static <T> List<T> collectStreamsData(Stream<T> firstStream, Stream<T> secondStream) {

    return Stream.concat(firstStream, secondStream).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    // System.out.println(numberdNamesUtil(Arrays.asList("Ivan", "Arnold", "Robert", "Dakota", "Mike", "Leonid")));
    // System.out.println(sortAndUppercase(Arrays.asList("hELLo", "worlD", "mY", "Name", "Is")));
    // System.out.println(collectElements(Arrays.asList("1, 2, 0", "4, 5")));

    //LongStream intStream = linearCongruentialGenerator(137L);
    //System.out.println(intStream.limit(10).boxed().collect(Collectors.toList()).toString());


    //System.out.println(getElementsFromBothStreams(Stream.of("1", "3", "5"), Stream.of("2", "4", "6")));
  }
}
