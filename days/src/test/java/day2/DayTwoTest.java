package day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

class DayTwoTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day2/test.txt");
    private final DayTwo dayTwo = new DayTwo();

    @Test
    void partOne() {
        long validPasswords = dayTwo.partOne(lines);
        Assertions.assertEquals(2, validPasswords);
    }

    @Test
    void partTwo() {
        long validPasswords = dayTwo.partTwo(lines);
        Assertions.assertEquals(1, validPasswords);
    }
}