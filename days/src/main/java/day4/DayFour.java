package day4;

import util.ReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class DayFour {

    public static void main(String[] args) {
        DayFour dayFour = new DayFour();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day4/input.txt");
        System.out.println("Part one:");
        System.out.println(dayFour.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayFour.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        List<Passport> passports = new ArrayList<>();
        String details = "";
        for (String line : lines) {
            details = details.concat(line + " ");
            if (line.isEmpty()) {
                passports.add(new Passport(details));
                details = "";
            }
        }
        passports.add(new Passport(details));
        return passports.stream().filter(Passport::isValidPartOne).count();
    }

    public long partTwo(List<String> lines) {
        List<Passport> passports = new ArrayList<>();
        String details = "";
        for (String line : lines) {
            details = details.concat(line + " ");
            if (line.isEmpty()) {
                passports.add(new Passport(details));
                details = "";
            }
        }
        passports.add(new Passport(details));
        return passports.stream().filter(Passport::isValidPartTwo).count();
    }

}
