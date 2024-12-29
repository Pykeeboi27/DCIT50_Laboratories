package Lab4_Inheritance;

public abstract class UnaryOperation extends Expression{

    Expression operand;

    UnaryOperation(Expression operand){
        this.operand = operand;
    }

    final Expression getOperand(){
        return operand;
    }
}
