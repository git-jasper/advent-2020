package day10;

public class JoltageMeter {

    private long oneJoltage;
    private long twoJoltage;
    private long threeJoltage;

    public JoltageMeter() {
    }

    public long oneJoltage() {
        return oneJoltage;
    }

    public long twoJoltage() {
        return twoJoltage;
    }

    public long threeJoltage() {
        return threeJoltage;
    }

    public void incrementOneJoltage() {
        this.oneJoltage++;
    }

    public void incrementTwoJoltage() {
        this.twoJoltage++;
    }

    public void incrementThreeJoltage() {
        this.threeJoltage++;
    }
}
