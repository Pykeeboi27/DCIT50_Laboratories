package Lab4_Inheritance;

public class Variable extends Expression{

    String name;

    Variable(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    Variable(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    void setValue(Integer value){
        this.value = value;
    }

    @Override
    Integer getValue(){
        return value;
    }

    @Override
    public String toString(){
        return name;
    }
}
