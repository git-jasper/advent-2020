package day8;

public class Instruction {

    private String operation;
    private Integer argument;

    public Instruction(String instruction) {
        String[] parts = instruction.split(" ");
        this.operation = parts[0];
        this.argument = Integer.parseInt(parts[1]);
    }

    public Instruction(String operation, Integer argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public String getOperation() {
        return operation;
    }

    public Integer getArgument() {
        return argument;
    }
}
