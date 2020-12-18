package day10;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTenTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day10/test.txt");
    private final DayTen dayTen = new DayTen();

    @Test
    void partOne() {
        long diff = dayTen.partOne(lines);
        assertEquals(220, diff);
    }

    @Test
    void partTwo() {
        long paths = dayTen.partTwo(lines);
        assertEquals(19208, paths);
    }
}