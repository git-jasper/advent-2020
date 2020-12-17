package day8;

public class Result {

    private final boolean success;
    private final Accumulator accumulator;

    public Result(boolean success, Accumulator accumulator) {
        this.success = success;
        this.accumulator = accumulator;
    }

    public boolean isSuccess() {
        return success;
    }

    public Accumulator getAccumulator() {
        return accumulator;
    }
}
