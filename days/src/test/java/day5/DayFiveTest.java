package day5;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFiveTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day5/test.txt");
    private DayFive dayFive = new DayFive();

    @Test
    void partOne() {
        int max = dayFive.partOne(lines);
        assertEquals(820, max);
    }

    @Test
    void partTwo() {
        List<String> codes = List.of("FFFFFFFLRL", "FFFFFFFLRR", "FFFFFFFRLR"); // ids 2, 3, 5
        assertEquals(4, dayFive.partTwo(codes));
    }
}