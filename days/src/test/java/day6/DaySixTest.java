package day6;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySixTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day6/test.txt");
    private DaySix daySix = new DaySix();

    @Test
    void partOne() {
        int sum = daySix.partOne(lines);
        assertEquals(11, sum);
    }

    @Test
    void partTwo() {
        int sum = daySix.partTwo(lines);
        assertEquals(6, sum);
    }
}