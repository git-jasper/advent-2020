package day11;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayElevenTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day11/test.txt");
    private final DayEleven dayEleven = new DayEleven();

    @Test
    void partOne() {
        long occupied = dayEleven.partOne(lines);
        assertEquals(37, occupied);
    }

    @Test
    void partTwo() {
        long occupied = dayEleven.partTwo(lines);
        assertEquals(26, occupied);
    }
}