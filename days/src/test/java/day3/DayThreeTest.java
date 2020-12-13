package day3;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThreeTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day3/test.txt");
    private final DayThree dayThree = new DayThree();

    @Test
    void partOne() {
        int trees = dayThree.partOne(lines);
        assertEquals(7, trees);
    }

    @Test
    void partTwo() {
        long result = dayThree.partTwo(lines);
        assertEquals(336, result);
    }
}