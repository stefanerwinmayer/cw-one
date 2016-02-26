package sml;

/**
 * This class ....
 *
 * @author someone
 */

public class BnzInstruction extends Instruction {
    private int register;
    private String label2;

    public BnzInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public BnzInstruction(String label, int register, String label2) {
        super(label, "bnz");
        this.register = register;
        this.label2 = label2;

    }

    @Override
    public void execute(Machine m) {
        if (m.getRegisters().getRegister(register) != 0) {
            m.getProg().stream().forEach(instruction -> {
                if (instruction.getLabel().equals(label2)) {
                    m.setPc(m.getProg().indexOf(instruction));
                }
            });
        }
    }

    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + label2;
    }
}
