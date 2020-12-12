package day1;

import util.ReaderUtil;

import java.util.List;

public class DayOne {
    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day1/input.txt");
        System.out.println("Part one:");
        System.out.println(dayOne.partOne(lines).toString());
        System.out.println("-----");
        System.out.println("Part two");
        System.out.println(dayOne.partTwo(lines).toString());
    }

    public Result partOne(List<String> lines) {
        for (String firstNum : lines) {
            int first = Integer.parseInt(firstNum);
            for (String secondNum : lines) {
                int second = Integer.parseInt(secondNum);
                if (first + second == 2020) {
                    return new Result(first, second);
                }
            }
        }
        return null;
    }

    public Result partTwo(List<String> lines) {
        for (String firstNum : lines) {
            int first = Integer.parseInt(firstNum);
            for (String secondNum : lines) {
                int second = Integer.parseInt(secondNum);
                for (String thirdNum : lines) {
                    int third = Integer.parseInt(thirdNum);
                    if (first + second + third == 2020) {
                        return new Result(first, second, third);
                    }
                }
            }
        }
        return null;
    }
}
