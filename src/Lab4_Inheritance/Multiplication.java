package Lab4_Inheritance;

public class Multiplication extends BinaryOperation{

    Multiplication(Expression leftOperand, Expression rightOperand){
        super(leftOperand, rightOperand);
    }

    @Override
    Integer getValue(){
        if (leftOperand.getValue() == null || rightOperand.getValue() == null){
            return null;
        }
        else{
            return leftOperand.getValue() * rightOperand.getValue();
        }
    }

    @Override
    public String toString(){
        return "(" + leftOperand + "*" + rightOperand + ")";
    }

}
