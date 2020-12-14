package day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardingPassTest {


    @Test
    void of() {
        BoardingPass pass1 = BoardingPass.of("BFFFBBFRRR");
        Assertions.assertEquals("BoardingPass{row=70, column=7, id=567}", pass1.toString());
        BoardingPass pass2 = BoardingPass.of("FFFBBBFRRR");
        Assertions.assertEquals("BoardingPass{row=14, column=7, id=119}", pass2.toString());
    }
}