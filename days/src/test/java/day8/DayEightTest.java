package day8;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayEightTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day8/test.txt");
    private final DayEight dayEight = new DayEight();

    @Test
    void partOne() {
        long accumulator = dayEight.partOne(lines);
        assertEquals(5, accumulator);
    }

    @Test
    void partTwo() {
        long accumulator = dayEight.partTwo(lines);
        assertEquals(8, accumulator);
    }
}