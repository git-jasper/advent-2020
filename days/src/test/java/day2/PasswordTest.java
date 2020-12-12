package day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    private final String input1 = "1-3 a: abcde";
    private final String input2 = "1-3 b: cdefg";


    @Test
    void of() {
        Password password = Password.of(input1);
        Assertions.assertEquals(1, password.getFirstDigit());
        Assertions.assertEquals(3, password.getSecondDigit());
        Assertions.assertEquals('a', password.getPolicyChar());
        Assertions.assertEquals("abcde", password.getPassword());
    }

    @Test
    void validPolicyPartOne() {
        Password valid = Password.of(input1);
        assertTrue(valid.isValidSledPolicy());
        Password invalid = Password.of(input2);
        assertFalse(invalid.isValidSledPolicy());
    }

    @Test
    void validPolicyPartTwo() {
        Password valid = Password.of(input1);
        assertTrue(valid.isValidTobogganPolicy());
        Password invalid = Password.of(input2);
        assertFalse(invalid.isValidTobogganPolicy());
    }
}