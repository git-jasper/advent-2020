package day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PassportTest {

    @Test
    void isValidPartOne() {
        Passport valid = new Passport("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");
        assertTrue(valid.isValidPartOne());
        Passport invalid = new Passport("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929");
        assertFalse(invalid.isValidPartOne());
    }

    @Test
    void isInvalidPartTwo() {
        Passport valid = new Passport("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f");
        assertTrue(valid.isValidPartTwo());
        Passport invalid = new Passport("eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926");
        assertFalse(invalid.isValidPartTwo());
    }
}