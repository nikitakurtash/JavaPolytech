import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public double calculateAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<String> transformToUpperAndAddPrefix(List<String> list) {
        return list.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Integer> uniqueSquares(List<Integer> list) {
        return list.stream()
                .filter(i -> Collections.frequency(list, i) == 1)
                .map(i -> i * i)
                .collect(Collectors.toList());
    }

    public List<String> stringsStartingWithLetter(List<String> list, char letter) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());
    }

    public <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }

    public int sumEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(i -> i % 2 == 0)
                .sum();
    }

    public Map<Character, String> stringsToMap(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (existing, replacement) -> existing));
    }
}
