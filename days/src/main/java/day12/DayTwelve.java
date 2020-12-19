package day12;

import util.ReaderUtil;

import java.util.List;

public class DayTwelve {

    public static void main(String[] args) {
        DayTwelve dayTwelve = new DayTwelve();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day12/input.txt");
        System.out.println("Part one:");
        System.out.println(dayTwelve.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayTwelve.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        Map map = new Map();
        for (String line : lines) {
            map.move(line);
        }
        return map.getDistance();
    }

    public long partTwo(List<String> lines) {
        Map map = new Map();
        for (String line : lines) {
            map.movePartTwo(line);
        }
        return map.getDistance();
    }
}
