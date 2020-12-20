package day13;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThirteenTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day13/test.txt");
    private final DayThirteen dayThirteen = new DayThirteen();

    @Test
    void partOne() {
        long value = dayThirteen.partOne(lines);
        assertEquals(295, value);
    }

    @Test
    void partTwo() {
        long value = dayThirteen.partTwo(lines);
        assertEquals(1068781, value);
        List<String> testLines = new ArrayList<>();
        testLines.add("test");
        testLines.add("1789,37,47,1889");
        long value2 = dayThirteen.partTwo(testLines);
        assertEquals(1202161486, value2);
    }
}