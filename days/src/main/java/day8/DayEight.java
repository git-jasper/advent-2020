package day8;

import util.ReaderUtil;

import java.util.HashSet;
import java.util.List;

public class DayEight {

    public static void main(String[] args) {
        DayEight dayEight = new DayEight();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day8/input.txt");
        System.out.println("Part one:");
        System.out.println(dayEight.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayEight.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        HashSet<Integer> indices = new HashSet<>();
        long accumulator = 0;
        for (int i = 0; i < lines.size();) {
            if (indices.contains(i)) {
                System.out.println(i);
                break;
            }
            indices.add(i);
            String[] instructions = lines.get(i).split(" ");
            String operation = instructions[0];
            int argument = Integer.parseInt(instructions[1]);
            switch (operation) {
                case "acc": {
                    accumulator += argument;
                    i++;
                    break;
                }
                case "jmp": {
                    i += argument;
                    break;
                }
                case "nop": {
                    i++;
                    break;
                }
            }

        }
        return accumulator;
    }

    public long partTwo(List<String> lines) {
        Result result = new Result(false, -1);
        for (int e = 0; e < lines.size(); e++) {
            Result attempt = runSequence(lines, "jmp", "nop", e);
            if (attempt.isSuccess()) {
                System.out.println("jmp -> nop, encounter: " + e);
                result = attempt;
                break;
            }
        }
        if (result.isSuccess()) {
            return result.getAccumulator();
        }
        for (int e = 0; e < lines.size(); e++) {
            Result attempt = runSequence(lines, "nop", "jmp", e);
            if (attempt.isSuccess()) {
                System.out.println("nop -> jmp, encounter: " + e);
                result = attempt;
                break;
            }
        };
        return result.getAccumulator();
    }

    private Result runSequence(List<String> lines, String original, String replacement, int encounter) {
        HashSet<Integer> indices = new HashSet<>();
        int originalEncounters = 0;
        long accumulator = 0;
        boolean success = true;
        for (int i = 0; i < lines.size();) {
            if (indices.contains(i)) {
                success = false;
                break;
            }
            indices.add(i);
            String[] instructions = lines.get(i).split(" ");
            String operation = instructions[0];
            if (operation.equals(original)) {
                if (originalEncounters == encounter) {
                    operation = replacement;
                }
                originalEncounters++;
            }
            int argument = Integer.parseInt(instructions[1]);
            switch (operation) {
                case "acc": {
                    accumulator += argument;
                    i++;
                    break;
                }
                case "jmp": {
                    i += argument;
                    break;
                }
                case "nop": {
                    i++;
                    break;
                }
            }

        }
        return new Result(success, accumulator);
    }
}
