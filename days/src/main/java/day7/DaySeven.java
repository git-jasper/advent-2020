package day7;

import util.ReaderUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaySeven {

    private static Pattern pattern = Pattern.compile("^([a-z ]+) bags contain (.*) bag.*");

    public static void main(String[] args) {
        DaySeven daySeven = new DaySeven();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day7/input.txt");
        System.out.println("Part one:");
        System.out.println(daySeven.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(daySeven.partTwo(lines));
    }

    private Map<String, Bag> processBags(List<String> lines) {
        Map<String, Bag> allBags = new HashMap<>();
        for (String line : lines) {
            Map<Bag, Integer> innerBags = new HashMap<>();
            Matcher matcher = pattern.matcher(line);
            matcher.matches();
            String outerBagColor = matcher.group(1);
            String containsBags = matcher.group(2);
            if (containsBags.equals("no other")) {
                continue;
            }
            String[] bagDetails = containsBags.split(" ");
            int i = 0;
            while (i < bagDetails.length) {
                int amount = Integer.parseInt(bagDetails[i]);
                String bagColor = bagDetails[i+1] + " " + bagDetails[i+2];
                Bag bag = allBags.getOrDefault(bagColor, new Bag(bagColor));
                innerBags.put(bag, amount);
                allBags.put(bagColor, bag);
                i += 4;
            }
            Bag outerBag = allBags.getOrDefault(outerBagColor, new Bag(outerBagColor));
            outerBag.putInnerBags(innerBags);
            allBags.put(outerBagColor, outerBag);
        }
        return allBags;
    }

    public long partOne(List<String> lines) {
        return processBags(lines).values().stream().filter(bag -> bag.contains("shiny gold")).count() - 1;
    }

    public long partTwo(List<String> lines) {
        return processBags(lines).get("shiny gold").countBags();
    }
}
