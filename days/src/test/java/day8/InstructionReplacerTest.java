package day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionReplacerTest {

    private final Instruction instruction = new Instruction("a", 0);

    @Test
    void replace() {
        InstructionReplacer instructionReplacer = new InstructionReplacer("a", "b", 2);
        Instruction original = instructionReplacer.replace(instruction);
        assertEquals("a", original.getOperation());
        Instruction replace = instructionReplacer.replace(original);
        assertEquals("b", replace.getOperation());
    }
}