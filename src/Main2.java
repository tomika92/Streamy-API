import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Main2 {
    public static void main(String[] args) {
        List<Integer> numbers = new Random().ints(10000, 0,
                10).boxed().toList();
        Map<Integer, Long> map =
                numbers.stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("Key: " +
                        entry.getKey() + " Value: " + entry.getValue()));
        System.out.println();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder(
                )))
                .forEach(entry -> System.out.println("Key: " +
                        entry.getKey() + " Value: " + entry.getValue()));
    }
}