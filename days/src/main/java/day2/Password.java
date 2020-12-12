package day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private static final Pattern PATTERN = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

    private final int firstDigit;
    private final int secondDigit;
    private final char policyChar;
    private final String password;

    public Password(int firstDigit, int secondDigit, char policyChar, String password) {
        this.firstDigit = firstDigit;
        this.secondDigit = secondDigit;
        this.policyChar = policyChar;
        this.password = password;
    }

    public boolean isValidSledPolicy() {
        long count = this.password.chars().filter(ch -> ch == this.policyChar).count();
        return firstDigit <= count && count <= secondDigit;
    }

    public boolean isValidTobogganPolicy() {
        return policyChar == password.charAt(firstDigit -1) ^ policyChar == password.charAt(secondDigit -1);
    }

    public static Password of(String input) {
        Matcher m = PATTERN.matcher(input);
        m.matches();
        int minCount = Integer.parseInt(m.group(1));
        int maxCount = Integer.parseInt(m.group(2));
        char character = m.group(3).charAt(0);
        return new Password(minCount, maxCount, character, m.group(4));
    }

    public int getFirstDigit() {
        return firstDigit;
    }

    public int getSecondDigit() {
        return secondDigit;
    }

    public char getPolicyChar() {
        return policyChar;
    }

    public String getPassword() {
        return password;
    }
}
