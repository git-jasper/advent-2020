package day7;

import java.util.HashMap;
import java.util.Map;

public class Bag {

    private final String color;
    private final Map<Bag, Integer> bags = new HashMap<>();

    public Bag(String color) {
        this.color = color ;
    }

    public boolean contains(String bagColor) {
        return this.color.equals(bagColor) || this.bags.keySet().stream().anyMatch(bag -> bag.contains(bagColor));
    }

    public void putInnerBags(Map<Bag, Integer> bags) {
        this.bags.putAll(bags);
    }

    public int countBags() {
        int count = 0;
        for (Map.Entry<Bag, Integer> bag : bags.entrySet()) {
            Integer value = bag.getValue();
            count += value + value * bag.getKey().countBags();
        }
        return count;
    }
}
