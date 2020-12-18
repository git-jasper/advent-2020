package day9;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DayNineTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day9/test.txt");
    private final DayNine dayNine = new DayNine();

    @Test
    void partOne() {
        long value = dayNine.partOne(lines, 5);
        assertEquals(127, value);
    }

    @Test
    void partTwo() {
        long value = dayNine.partTwo(lines, 5);
        assertEquals(62, value);
    }
}