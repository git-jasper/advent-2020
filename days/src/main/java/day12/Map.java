package day12;

import static day12.Map.Direction.EAST;
import static day12.Map.Direction.NORTH;
import static day12.Map.Direction.SOUTH;
import static day12.Map.Direction.WEST;

public class Map {

    private long x;
    private long y;
    private long xWay = 10;
    private long yWay = 1;
    private Direction current = EAST;


    public Map() {
    }

    public void move(String move) {
        int argument = Integer.parseInt(move.substring(1));
        switch (move.charAt(0)) {
            case 'N':
                this.y += argument;
                break;
            case 'E':
                this.x += argument;
                break;
            case 'S':
                this.y -= argument;
                break;
            case 'W':
                this.x -= argument;
                break;
            case 'F':
                move(current.move + argument);
                break;
            case 'R':
                rotateRight(argument);
                break;
            case 'L':
                rotateLeft(argument);
                break;
        }
    }

    public void movePartTwo(String move) {
        int argument = Integer.parseInt(move.substring(1));
        switch (move.charAt(0)) {
            case 'N':
                this.yWay += argument;
                break;
            case 'E':
                this.xWay += argument;
                break;
            case 'S':
                this.yWay -= argument;
                break;
            case 'W':
                this.xWay -= argument;
                break;
            case 'F':
                long xDiff = xWay - x;
                long yDiff = yWay - y;
                x += xDiff * argument;
                y += yDiff * argument;
                xWay = x + xDiff;
                yWay = y + yDiff;
                break;
            case 'R':
                rotateRightPartTwo(argument);
                break;
            case 'L':
                rotateLeftPartTwo(argument);
                break;
        }
    }

    private void rotateRightPartTwo(int argument) {
        long xDiff = xWay - x;
        long yDiff = yWay - y;
        xWay = x + yDiff;
        yWay = y - xDiff;
        argument -= 90;
        if (argument > 0) {
            rotateRightPartTwo(argument);
        }
    }

    private void rotateLeftPartTwo(int argument) {
        long xDiff = xWay - x;
        long yDiff = yWay - y;
        xWay = x - yDiff;
        yWay = y + xDiff;
        argument -= 90;
        if (argument > 0) {
            rotateLeftPartTwo(argument);
        }
    }

    private void rotateRight(int argument) {
        switch (current) {
            case NORTH:
                this.current = EAST;
                break;
            case EAST:
                this.current = SOUTH;
                break;
            case SOUTH:
                this.current = WEST;
                break;
            case WEST:
                this.current = NORTH;
                break;
        }
        argument -= 90;
        if (argument > 0) {
            rotateRight(argument);
        }
    }

    private void rotateLeft(int argument) {
        switch (current) {
            case NORTH:
                this.current = WEST;
                break;
            case EAST:
                this.current = NORTH;
                break;
            case SOUTH:
                this.current = EAST;
                break;
            case WEST:
                this.current = SOUTH;
                break;
        }
        argument -= 90;
        if (argument > 0) {
            rotateLeft(argument);
        }
    }

    public long getDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    enum Direction {
        NORTH("N"),
        EAST("E"),
        SOUTH("S"),
        WEST("W");

        private String move;

        Direction(String move) {
            this.move = move;
        }
    }
}
