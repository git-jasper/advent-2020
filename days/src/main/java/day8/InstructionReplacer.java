package day8;

public class InstructionReplacer implements Replacer{

    private final String original;
    private final String replacement;
    private final int replaceOnEncounter;
    private int encounters;

    public InstructionReplacer(String original, String replacement, int replaceOnEncounter) {
        this.original = original;
        this.replacement = replacement;
        this.replaceOnEncounter = replaceOnEncounter;
    }

    @Override
    public Instruction replace(Instruction instruction) {
        if (this.original.equals(instruction.getOperation())) {
            this.encounters += 1;
            if (this.replaceOnEncounter == this.encounters) {
                return new Instruction(replacement, instruction.getArgument());
            }
        }
        return instruction;
    }
}
