package day9;

import util.ReaderUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DayNine {

    public static void main(String[] args) {
        DayNine dayNine = new DayNine();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day9/input.txt");
        System.out.println("Part one:");
        System.out.println(dayNine.partOne(lines, 25));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayNine.partTwo(lines , 25));
    }

    public long partOne(List<String> lines, int preamble) {
        long[] input = lines.stream().mapToLong(Long::parseLong).toArray();
        return findInvalid(input, preamble);
    }

    public long partTwo(List<String> lines, int preamble) {
        long[] input = lines.stream().mapToLong(Long::parseLong).toArray();
        long invalid = findInvalid(input, preamble);
        List<Long> list = new ArrayList<>();
        int index = 0;
        while(true) {
            long sum = 0;
            for (int i = index; i < input.length; i++) {
                sum += input[i];
                if (sum > invalid) {
                    list.clear();
                    break;
                }
                list.add(input[i]);
                if (sum == invalid) {
                    Long min = list.stream().min(Long::compareTo).get();
                    Long max = list.stream().max(Long::compareTo).get();
                    return min + max;
                }
            }
            index++;
        }
    }

    private long findInvalid(long[] input, int preamble) {
        LinkedList<Long[]> allSums = initialise(input, preamble);
        for (int i = preamble; i < input.length; i++) {
            long value = input[i];
            if (!contains(allSums, value)) {
                return value;
            }
            allSums.removeFirst();
            updateAllSums(allSums, input, i, value);
            allSums.add(new Long[preamble-1]);
        }
        return -1;
    }

    private void updateAllSums(LinkedList<Long[]> allSums, long[] input, int inputIndex, long value) {
        int size = allSums.size();
        int index = size-1;
        for (Long[] sumArray : allSums) {
            sumArray[index] = input[inputIndex-size] + value;
            inputIndex++;
            index--;
        }
    }

    private boolean contains(LinkedList<Long[]> sums, Long value) {
        for (Long[] sumArray : sums) {
            for (Long sum : sumArray) {
                if (value.equals(sum)) {
                    return true;
                }
            }
        }
        return false;
    }

    private LinkedList<Long[]> initialise(long[] input, int preamble) {
        LinkedList<Long[]> list = new LinkedList<>();
        int startIndex = 0;
        for (int p = 0; p < preamble; p++) {
            Long[] sums = new Long[preamble-1];
            for (int s = startIndex; s < preamble-1; s++) {
                sums[s-p] = input[p] + input[s+1];
            }
            list.add(sums);
            startIndex++;
        }
        return list;
    }
}
