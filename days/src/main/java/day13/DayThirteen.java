package day13;

import util.ReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class DayThirteen {

    public static void main(String[] args) {
        DayThirteen dayThirteen = new DayThirteen();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day13/input.txt");
        System.out.println("Part one:");
        System.out.println(dayThirteen.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayThirteen.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        long arrival = Long.parseLong(lines.get(0));
        long waitTime = arrival;
        long earliestBus = 0;
        for (String id : lines.get(1).split(",")) {
            if ("x".equals(id)) {
                continue;
            }
            long bus = Long.parseLong(id);
            long wait = bus - arrival % bus;
            if (wait < waitTime) {
                waitTime = wait;
                earliestBus = bus;
            }
        }
        return earliestBus * waitTime;
    }

    public long partTwo(List<String> lines) {
        List<Bus> buses = getBuses(lines);
        long product = 1;
        for (Bus bus : buses) {
            product *= bus.getId();
        }
        for (Bus bus : buses) {
            bus.setN(product);
            bus.setX();
        }
        long sum = buses.stream().mapToLong(Bus::getProduct).sum();
        return sum - (sum / product * product);
    }

    private List<Bus> getBuses(List<String> lines) {
        List<Bus> buses = new ArrayList<>();
        String[] ids = lines.get(1).split(",");
        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            if ("x".equals(id)) {
                continue;
            }
            buses.add(new Bus(i, Long.parseLong(id)));
        }
        return buses;
    }
}
