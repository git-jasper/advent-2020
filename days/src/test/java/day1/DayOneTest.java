package day1;

import org.junit.jupiter.api.Test;
import util.ReaderUtil;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTest {

    private final List<String> lines = ReaderUtil.read("src/main/resources/day1/test.txt");
    private final DayOne dayOne = new DayOne();

    @Test
    void partOne() {
        Result result = dayOne.partOne(lines);
        assertEquals(1721, result.getFirst());
        assertEquals(299, result.getSecond());
        assertEquals(514579, result.getProduct());
    }

    @Test
    void partTwo() {
        Result result = dayOne.partTwo(lines);
        assertEquals(979, result.getFirst());
        assertEquals(366, result.getSecond());
        assertEquals(675, result.getThird());
        assertEquals(241861950, result.getProduct());
    }
}