package day8;

public class Accumulator {

    private long value;

    public Accumulator(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    void accumulate(long value) {
        this.value += value;
    }
}
