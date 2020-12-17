package day8;

public class Result {

    private final boolean success;
    private final long accumulator;

    public Result(boolean success, long accumulator) {
        this.success = success;
        this.accumulator = accumulator;
    }

    public boolean isSuccess() {
        return success;
    }

    public long getAccumulator() {
        return accumulator;
    }
}
