package day2;

import util.ReaderUtil;

import java.util.List;

public class DayTwo {
    public static void main(String[] args) {
        DayTwo dayTwo = new DayTwo();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day2/input.txt");
        System.out.println("Part one:");
        System.out.println(dayTwo.partOne(lines));
        System.out.println("-----");
        System.out.println("Part two");
        System.out.println(dayTwo.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        return lines.stream().map(Password::of).filter(Password::isValidSledPolicy).count();
    }

    public long partTwo(List<String> lines) {
        return lines.stream().map(Password::of).filter(Password::isValidTobogganPolicy).count();
    }

}
