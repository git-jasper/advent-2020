package day11;

import util.ReaderUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DayEleven {

    public static void main(String[] args) {
        DayEleven dayEleven = new DayEleven();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day11/input.txt");
        System.out.println("Part one:");
        System.out.println(dayEleven.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(dayEleven.partTwo(lines));
    }

    public long partOne(List<String> lines) {
        int columns = lines.get(0).length();
        HashMap<Integer, Seat> seats = mapSeats(lines, columns);
        partOneAdjacent(seats, columns);
        return changeSeats(seats, 4);
    }

    public long partTwo(List<String> lines) {
        int columns = lines.get(0).length();
        HashMap<Integer, Seat> seats = mapSeats(lines, columns);
        partTwoAdjacent(seats, lines.size(), columns);
        return changeSeats(seats, 5);
    }

    private long changeSeats(HashMap<Integer, Seat> seats, int sensitivity) {
        boolean seatsChanging;
        do {
            seatsChanging = false;
            for (Seat seat : seats.values()) {
                if (seat.nextState(sensitivity)) {
                    seatsChanging = true;
                }
            }
            for (Seat seat : seats.values()) {
                seat.update();
            }
        } while (seatsChanging);
        return seats.values().stream().filter(Seat::isOccupied).count();
    }

    private void partTwoAdjacent(HashMap<Integer, Seat> seats, int rows, int columns) {
        int max = (rows - 1) * columns;
        for (Integer seatNumber : seats.keySet()) {
            LinkedList<Seat> adjacent = new LinkedList<>();
            adjacent.add(findUp(seats, seatNumber, columns));
            adjacent.add(findUpLeft(seats, seatNumber, columns));
            adjacent.add(findUpRight(seats, seatNumber, columns));
            adjacent.add(findLeft(seats, seatNumber, columns));
            adjacent.add(findRight(seats, seatNumber, columns));
            adjacent.add(findDown(seats, seatNumber, max, columns));
            adjacent.add(findDownLeft(seats, seatNumber, max, columns));
            adjacent.add(findDownRight(seats, seatNumber, max, columns));
            adjacent.removeIf(Objects::isNull);
            seats.get(seatNumber).setAdjacent(adjacent);
        }
    }

    private Seat findUp(HashMap<Integer, Seat> seats, int seatNumber, int columns) {
        while(seatNumber > columns) {
            seatNumber -= columns;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findUpLeft(HashMap<Integer, Seat> seats, int seatNumber, int columns) {
        while(seatNumber > columns && seatNumber % columns != 1) {
            seatNumber -= columns + 1;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findUpRight(HashMap<Integer, Seat> seats, int seatNumber, int columns) {
        while(seatNumber > columns && seatNumber % columns != 0) {
            seatNumber -= columns - 1;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findLeft(HashMap<Integer, Seat> seats, int seatNumber, int columns) {
        while(seatNumber % columns != 1) {
            seatNumber -= 1;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findRight(HashMap<Integer, Seat> seats, int seatNumber, int columns) {
        while(seatNumber % columns != 0) {
            seatNumber += 1;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findDown(HashMap<Integer, Seat> seats, int seatNumber, int max, int columns) {
        while(seatNumber <= max) {
            seatNumber += columns;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findDownLeft(HashMap<Integer, Seat> seats, int seatNumber, int max, int columns) {
        while(seatNumber <= max && seatNumber % columns != 1) {
            seatNumber += columns - 1;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private Seat findDownRight(HashMap<Integer, Seat> seats, int seatNumber, int max, int columns) {
        while(seatNumber <= max && seatNumber % columns != 0) {
            seatNumber += columns + 1;
            Seat seat = seats.get(seatNumber);
            if (seat != null) {
                return seat;
            }
        }
        return null;
    }

    private void partOneAdjacent(HashMap<Integer, Seat> seats, int columns) {
        for (Integer seatNumber : seats.keySet()) {
            LinkedList<Seat> adjacent = new LinkedList<>();
            adjacent.add(seats.get(seatNumber + columns));
            adjacent.add(seats.get(seatNumber - columns));
            int remainder = seatNumber % columns;
            if (remainder == 1) {
                adjacent.add(seats.get(seatNumber - columns + 1));
                adjacent.add(seats.get(seatNumber + 1));
                adjacent.add(seats.get(seatNumber + columns + 1));
            } else if (remainder == 0) {
                adjacent.add(seats.get(seatNumber - columns - 1));
                adjacent.add(seats.get(seatNumber - 1));
                adjacent.add(seats.get(seatNumber + columns - 1));
            } else {
                adjacent.add(seats.get(seatNumber - columns - 1));
                adjacent.add(seats.get(seatNumber - columns + 1));
                adjacent.add(seats.get(seatNumber - 1));
                adjacent.add(seats.get(seatNumber + 1));
                adjacent.add(seats.get(seatNumber + columns - 1));
                adjacent.add(seats.get(seatNumber + columns + 1));
            }
            adjacent.removeIf(Objects::isNull);
            seats.get(seatNumber).setAdjacent(adjacent);
        }
    }

    private HashMap<Integer, Seat> mapSeats(List<String> lines, int columns) {
        HashMap<Integer, Seat> seats = new HashMap<>();
        int seat = 0;
        for (String line : lines) {
            for (int s = 0; s < columns; s++) {
                if ('L' == line.charAt(s)) {
                    seats.put(1+seat+s, new Seat());
                }
            }
            seat += columns;
        }
        return seats;
    }
}
