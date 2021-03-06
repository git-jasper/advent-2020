package day10;

import util.ReaderUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DayTen {

    public static void main(String[] args) {
        DayTen dayTen = new DayTen();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day10/input.txt");
        System.out.println("Part one:");
        System.out.println(dayTen.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayTen.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        HashSet<Long> adapters = new HashSet<>();
        lines.forEach(line-> {
            adapters.add(Long.parseLong(line));
        });
        JoltageMeter joltageMeter = new JoltageMeter();
        long output = 0L;
        int index = 0;
        while (index < adapters.size()) {
            if (adapters.contains(++output)) {
                joltageMeter.incrementOneJoltage();
                continue;
            }
            if (adapters.contains(++output)) {
                joltageMeter.incrementTwoJoltage();
                continue;
            }
            if (adapters.contains(++output)) {
                joltageMeter.incrementThreeJoltage();
                continue;
            }
            index++;
        }
        joltageMeter.incrementThreeJoltage(); // built-in device adapter
        return joltageMeter.oneJoltage() * joltageMeter.threeJoltage();
    }

    public long partTwo(List<String> lines) {
        HashMap<Long, Long> paths = initPaths(lines);
        Pointer pointer = new Pointer();
        do {
            pointer.next();
            checkWays(paths, pointer, paths.get(pointer.position()));
        } while (pointer.hasNext());
        return paths.get(pointer.position());
    }

    private void checkWays(HashMap<Long, Long> paths, Pointer pointer, Long value) {
        // check joltage 3 times (for 3, 2, 1 difference)
        checkJoltage(paths, pointer, value);
        checkJoltage(paths, pointer, value);
        checkJoltage(paths, pointer, value);
    }

    private void checkJoltage(HashMap<Long, Long> paths, Pointer pointer, Long value) {
        long jolt = pointer.decrement();
        if (paths.containsKey(jolt)) {
            paths.put(jolt, value + paths.get(jolt));
            pointer.update();
        }
    }

    private HashMap<Long, Long> initPaths(List<String> lines) {
        HashMap<Long, Long> paths = new HashMap<>();
        paths.put(0L, 1L);
        lines.forEach(line-> {
            paths.put(Long.parseLong(line), 0L);
        });
        return paths;
    }
}
