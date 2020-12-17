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
        Result result = runSequence(lines, new NoOpReplacer());
        return result.getAccumulator().getValue();
    }

    public long partTwo(List<String> lines) {
        for (int e = 0; e < lines.size(); e++) {
            Result attempt = runSequence(lines, new InstructionReplacer("jmp", "nop", e));
            if (attempt.isSuccess()) {
                return attempt.getAccumulator().getValue();
            }
        }
        for (int e = 0; e < lines.size(); e++) {
            Result attempt = runSequence(lines, new InstructionReplacer("nop", "jmp", e));
            if (attempt.isSuccess()) {
                return attempt.getAccumulator().getValue();
            }
        }
        return -1;
    }

    private Result runSequence(List<String> lines, Replacer replacer) {
        HashSet<Integer> indices = new HashSet<>();
        Accumulator accumulator = new Accumulator(0);
        Index index = new Index(0);
        do {
            int value = index.getValue();
            if (indices.contains(value)) {
                return new Result(false, accumulator);
            }
            indices.add(value);
            Instruction instruction = new Instruction(lines.get(value));
            Instruction replace = replacer.replace(instruction);
            performInstruction(replace, accumulator, index);
        } while (index.getValue() < lines.size());
        return new Result(true, accumulator);
    }

    private void performInstruction(Instruction replace, Accumulator accumulator, Index index) {
        switch (replace.getOperation()) {
            case "acc": {
                accumulator.accumulate(replace.getArgument());
                index.increment(1);
                break;
            }
            case "jmp": {
                index.increment(replace.getArgument());
                break;
            }
            case "nop": {
                index.increment(1);
                break;
            }
        }
    }
}
