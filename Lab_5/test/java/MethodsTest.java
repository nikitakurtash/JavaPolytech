import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class MethodsTest {

    Methods utils = new Methods();

    @Test
    void testCalculateAverage() {
        assertEquals(3.0, utils.calculateAverage(Arrays.asList(1, 2, 3, 4, 5)), 0.01);
    }

    @Test
    void testTransformToUpperAndAddPrefix() {
        List<String> expected = Arrays.asList("_new_APPLE", "_new_BANANA", "_new_CHERRY");
        assertEquals(expected, utils.transformToUpperAndAddPrefix(Arrays.asList("apple", "banana", "cherry")));
    }

    @Test
    void testUniqueSquares() {
        List<Integer> expected = Arrays.asList(1, 9, 16);
        assertEquals(expected, utils.uniqueSquares(Arrays.asList(1, 2, 2, 3, 4)));
    }

    @Test
    void testStringsStartingWithLetter() {
        List<String> expected = Arrays.asList("anchor", "ant", "apple");
        assertEquals(expected, utils.stringsStartingWithLetter(Arrays.asList("ant", "anchor", "balloon", "apple"), 'a'));
    }

    @Test
    void testGetLastElement() {
        assertEquals("three", utils.getLastElement(Arrays.asList("one", "two", "three")));
    }

    @Test
    void testSumEvenNumbers() {
        assertEquals(12, utils.sumEvenNumbers(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void testStringsToMap() {
        Map<Character, String> expected = new HashMap<>();
        expected.put('a', "pple");
        expected.put('b', "anana");
        expected.put('c', "herry");
        assertEquals(expected, utils.stringsToMap(Arrays.asList("apple", "banana", "cherry")));
    }
}
