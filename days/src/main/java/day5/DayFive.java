package day5;

import util.ReaderUtil;

import java.util.List;

public class DayFive {

    public static void main(String[] args) {
        DayFive dayFive = new DayFive();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day5/input.txt");
        System.out.println("Part one:");
        System.out.println(dayFive.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayFive.partTwo(lines));
    }

    public int partOne(List<String> lines) {
        return lines.stream().map(BoardingPass::of).mapToInt(BoardingPass::getId).max().orElse(-1);
    }

    public int partTwo(List<String> lines) {
        int min = 999;
        int max = 0;
        int sum = 0;
        for (String line : lines) {
            int id = BoardingPass.of(line).getId();
            if (id < min) {
                min = id;
            }
            if (id > max) {
                max = id;
            }
            sum += id;
        }
        int boardingPassSum = calculateSum(max) - calculateSum(min - 1);
        return boardingPassSum - sum;
    }

    public int calculateSum(int size) {
        return size * (size + 1) / 2;
    }
}
