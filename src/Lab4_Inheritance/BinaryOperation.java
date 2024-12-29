package Lab4_Inheritance;

public abstract class BinaryOperation extends Expression{

    Expression leftOperand;
    Expression rightOperand;

    BinaryOperation(Expression leftOperand, Expression rightOperand){
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    final Expression getLeftOperand(){
        return leftOperand;
    }

    final Expression getRightOperand(){
        return rightOperand;
    }

}
