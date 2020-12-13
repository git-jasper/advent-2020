package day4;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day4/test.txt");
    private final DayFour dayFour = new DayFour();

    @Test
    void partOne() {
        long validPassports = dayFour.partOne(lines);
        assertEquals(2, validPassports);
    }

    @Test
    void partTwo() {
        long validPassports = dayFour.partTwo(lines);
        assertEquals(2, validPassports);
    }
}