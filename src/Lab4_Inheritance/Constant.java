package Lab4_Inheritance;

public class Constant extends Expression{

    Constant(Integer value){
        this.value = value;
    }

    @Override
    Integer getValue(){
        return value;
    }

//    String toString(){
//
//    }
}
