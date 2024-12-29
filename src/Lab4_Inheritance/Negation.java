package Lab4_Inheritance;

public class Negation extends UnaryOperation {

    Negation(Expression operand) {
        super(operand);
    }

    @Override
    Integer getValue() {
        if (operand.getValue() == null) {
            return null;
        } else {
            return operand.getValue() * -1;
        }
    }

    @Override
    public String toString() {
        if (operand.getValue() == null) {
            return "-" + operand.toString();
        }
        return "" + operand.getValue() * -1;
    }
}

