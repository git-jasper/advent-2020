package day11;

import java.util.LinkedList;

public class Seat {

    private boolean occupied;
    private boolean nextState;
    private LinkedList<Seat> adjacent = new LinkedList<>();

    public Seat() {
    }

    public void update() {
        this.occupied = this.nextState;
    }

    public boolean nextState(int sensitivity) {
        if (this.occupied) {
            int occupiedCount = 0;
            for (Seat adj : adjacent) {
                if (adj.isOccupied()) {
                    occupiedCount++;
                }
            }
            this.nextState = occupiedCount < sensitivity;
        } else {
            boolean willBeTaken = true;
            for (Seat adj : adjacent) {
                if (adj.occupied) {
                    willBeTaken = false;
                    break;
                }
            }
            this.nextState = willBeTaken;
        }
        return this.occupied != this.nextState;
    }

    public void setAdjacent(LinkedList<Seat> adjacent) {
        this.adjacent.addAll(adjacent);
    }

    public boolean isOccupied() {
        return occupied;
    }
}
