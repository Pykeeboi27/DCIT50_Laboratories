package Lab6_ZooManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    //Shows the menu of actions available in the program
    private static void showMenu(){
        System.out.println("\n=== Zoo Management System ===");
        System.out.println("1. Add Animal");
        System.out.println("2. View All Animal");
        System.out.println("3. Hear Animal Sounds");
        System.out.println("4. Exit");
    }

    //Asks for the user's action in the program
    private static int menuChoice(Scanner sc){

        int choice;

        do{
            try{
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                break;
            }
            catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Error: Can only input integer values. Try again.");
            }

        }while(true);

        return choice;
    }

    //Method that shows all the animals in the system
    private static void showAnimals(ArrayList<Animal> animals){
        if (animals.isEmpty()){
            System.out.println("\nNo animals to show.");
        }
        else{
            System.out.println("\n========== Animals in the Zoo =========");
            for (Animal animal: animals){
                System.out.println("Name    : " + animal.getName());
                System.out.println("Species : " + animal.getSpecies());
                System.out.println("Age     : " + animal.getAge());
                System.out.println("=======================================");
            }
        }
    }

    //Method that shows all the sounds that the animals make in the system
    private static void showAnimalSounds(ArrayList<Animal> animals){
        if (animals.isEmpty()){
            System.out.println("\nNo animals in the zoo to make a sound.");
        }
        else{
            System.out.println("\n========== Animals in the Zoo =========");
            for (Animal animal: animals){
                animal.makeSound();
            }
        }
    }

    //Method that adds an animal in the system
    private static void addAnimal(Scanner sc, ArrayList<Animal> animals){

        sc.nextLine();

        Animal a = new Animal();

        System.out.println("\n========== Add an Animal ==========");
        String name = getValidName(sc);
        String species = getValidSpecies(sc);
        int age = getValidAge(sc);

        a.setName(name);
        a.setSpecies(species);
        a.setAge(age);
        animals.add(a);

        System.out.println("Animal successfully added!");


    }

    //Method inside addAnimal() that asks for the animal's valid name
    private static String getValidName(Scanner sc){
        String name;

        while(true){
            System.out.print("Enter animal's name: ");
            name = sc.nextLine().trim();

            if (name.isEmpty()){
                System.out.println("Error: Name cannot be empty. Try again.");
            }
            else if (name.matches(".*\\d.*")){
                System.out.println("Error: Name cannot include any numbers. Try again.");
            }
            else{break;}
        }
        return name;
    }

    //Method inside addAnimal() that asks for the animal's valid species name
    private static String getValidSpecies(Scanner sc){
        String species;

        while(true){
            System.out.print("Enter animal's species: ");
            species = sc.nextLine().trim();

            if (species.isEmpty()){
                System.out.println("Error: Species cannot be empty. Try again.");
            }
            else if (species.matches(".*\\d.*")){
                System.out.println("Error: Species cannot include any numbers. Try again.");
            }
            else{break;}
        }
        return species;
    }

    //Method inside addAnimal() that asks for the animal's valid age
    private static int getValidAge(Scanner sc){
        int age;

        while (true){
            try {
                System.out.print("Enter animal's age: ");
                age = sc.nextInt();

                if (age < 0){
                    System.out.println("Error: Please enter an age that 0 and above.");
                }
                else {
                    break;
                }
            }
            catch(InputMismatchException e) {
                sc.nextLine();
                System.out.println("Error: Please enter a numerical name. Try again.");
            }
        }

        return age;
    }

    //Method that checks whether there the program can still add an animal in the system
    private static boolean canStillStore(ArrayList<Animal> animals){
        for (int i = 0; i < animals.size(); i++){
            if (i == 4){
                return false;
            }
        }
        return true;
    }

    //The main program that combines all the methods
    private static void mainProgram(Scanner sc, ArrayList<Animal> animals){

        boolean programIsRunning = true;

        while(programIsRunning) {
            showMenu();
            int action = menuChoice(sc);

            while (action != 1 && action != 2 && action != 3 && action !=4){
                System.out.println("Error: Please only choose a number between 1-4. Try again.");
                action = menuChoice(sc);
            }
            if (action == 1){
                if (canStillStore(animals)) {
                    addAnimal(sc, animals);
                }
                else{
                    System.out.println("Sorry! Our zoo is already full and can only store 5 animals. Cannot add any more.");
                }
            }
            else if (action == 2){
                showAnimals(animals);
            }
            else if (action == 3){
                showAnimalSounds(animals);
            }
            else{
                System.out.println("\nExiting program...");
                programIsRunning = false;
            }

        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<Animal>();

        Animal a = new Animal();
        a.setName("Jiroh");
        a.setSpecies("Dog");
        a.setAge(24);

        Animal b = new Animal();
        b.setName("Michael");
        b.setSpecies("Cat");
        b.setAge(10);

        Animal c = new Animal();
        b.setName("Lourence");
        b.setSpecies("Dinosaur");
        b.setAge(1017);

        animals.add(a);
        animals.add(b);
        animals.add(c);

        System.out.println(canStillStore(animals));
        mainProgram(sc, animals);


    }
}
