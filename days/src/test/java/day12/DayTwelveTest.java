package day12;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwelveTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day12/test.txt");
    private final DayTwelve dayTwelve = new DayTwelve();

    @Test
    void partOne() {
        long distance = dayTwelve.partOne(lines);
        assertEquals(25, distance);
    }

    @Test
    void partTwo() {
        long distance = dayTwelve.partTwo(lines);
        assertEquals(286, distance);
    }
}