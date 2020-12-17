package day8;

public class Index {

    private int value;

    public Index(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increment(int value) {
        this.value += value;
    }
}
