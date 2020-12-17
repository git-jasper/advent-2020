package day8;

public class NoOpReplacer implements Replacer {

    @Override
    public Instruction replace(Instruction instruction) {
        return instruction;
    }
}
