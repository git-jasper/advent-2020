package day7;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySevenTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day7/test.txt");
    private final List<String> linesPartTwo = ReaderUtil.read("src/main/resources/day7/test2.txt");
    private final DaySeven daySeven = new DaySeven();

    @Test
    void partOne() {
        long amount = daySeven.partOne(lines);
        assertEquals(4, amount);
    }

    @Test
    void partTwo() {
        long amount = daySeven.partTwo(linesPartTwo);
        assertEquals(126, amount);
    }
}