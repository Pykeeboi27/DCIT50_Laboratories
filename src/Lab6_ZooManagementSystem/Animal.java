package Lab6_ZooManagementSystem;

public class Animal {

    private String name;
    private String species;
    private int age;

    //Constructor
    Animal (String name, String species, int age){
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public void makeSound(){
        System.out.println(name + " the animal makes a generic sound!");
    }
    //Getters for the attributes
    public String getName(){
        return this.name;
    }

    public String getSpecies(){
        return this.species;
    }

    public int getAge(){
        return this.age;
    }

    //Setters for the attributes
    public void setName(String name){
        this.name = name;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public void setAge(int age){
        this.age = age;
    }
}
