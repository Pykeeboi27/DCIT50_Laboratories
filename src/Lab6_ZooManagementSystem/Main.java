package Lab6_ZooManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    private static void showMenu(){
        System.out.println("\n=== Zoo Management System ===");
        System.out.println("1. Add Animal");
        System.out.println("2. View All Animal");
        System.out.println("3. Hear Animal Sounds");
        System.out.println("4. Exit");
    }

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

    private static void addAnimal(Scanner sc, ArrayList<Animal> animals){

        sc.nextLine();

        System.out.println("\n========== Add an Animal ==========");
        String name = getValidName(sc);
    }

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

    public static void mainProgram(Scanner sc, ArrayList<Animal> animals){

        boolean programIsRunning = true;

        while(programIsRunning) {
            showMenu();
            int action = menuChoice(sc);

            while (action != 1 && action != 2 && action != 3 && action !=4){
                System.out.println("Error: Please only choose a number between 1-4. Try again.");
                action = menuChoice(sc);
            }
            if (action == 1){
                addAnimal(sc, animals);
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

        Animal a = new Animal("Jiroh", "Dog", 24);
        Animal b = new Animal("Michael", "Cat", 10);
        Animal c = new Animal("Lourence","Dinosaur", 1017);

        animals.add(a);
        animals.add(b);
        animals.add(c);

        mainProgram(sc, animals);


    }
}
