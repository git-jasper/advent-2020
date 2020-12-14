package day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormTest {

    @Test
    void of() {
        Form form1 = new Form("abc");
        assertEquals(3, form1.getSum());
        Form form2 = new Form("aaaa");
        assertEquals(1, form2.getSum());
    }
}