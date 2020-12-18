package day10;

public class Pointer {

    private long current;
    private long output;
    private long jolt;

    public Pointer() {
    }

    public void next() {
        this.current = this.output;
        this.jolt = this.current + 4;
    }

    public void update() {
        this.output = this.jolt;
    }

    public boolean hasNext() {
        return this.current != this.output;
    }

    public long decrement() {
        return --this.jolt;
    }

    public long position() {
        return this.current;
    }
}
