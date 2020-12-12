package day3;

import util.ReaderUtil;

import java.util.List;

public class DayThree {

    public static void main(String[] args) {
        DayThree dayThree = new DayThree();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day3/input.txt");
        System.out.println("Part one:");
        System.out.println(dayThree.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayThree.partTwo(lines));
    }

    public int partOne(List<String> lines) {
        return countTrees(lines, 1, 3);
    }

    public long partTwo(List<String> lines) {
        long slope1 = countTrees(lines, 1, 1);
        long slope2 = countTrees(lines, 1, 3);
        long slope3 = countTrees(lines, 1, 5);
        long slope4 = countTrees(lines, 1, 7);
        long slope5 = countTrees(lines, 2, 1);
        return slope1 * slope2 * slope3 * slope4 * slope5;
    }

    public int countTrees(List<String> lines, int rowStep, int columnStep) {
        int trees = 0;
        int column = 0;
        int maxChar = lines.get(0).length();
        for (int row = rowStep; row < lines.size(); row += rowStep) {
            column = updateColumn(column, columnStep, maxChar);
            if ('#' == lines.get(row).charAt(column)) {
                trees++;
            }
        }
        return trees;
    }

    private int updateColumn(int column, int columnStep, int maxChar) {
        column += columnStep;
        if (column >= maxChar) {
            column = column - maxChar;
        }
        return column;
    }
}
