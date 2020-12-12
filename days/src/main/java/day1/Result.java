package day1;

public class Result {

    private final Integer first;
    private final Integer second;
    private final Integer third;
    private final Integer product;

    public Result(int first, int second) {
        this.first = first;
        this.second = second;
        this.third = null;
        this.product = first * second;
    }

    public Result(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.product = first * second * third;
    }


    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public Integer getThird() {
        return third;
    }

    public Integer getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Result{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", product=" + product +
                '}';
    }
}
