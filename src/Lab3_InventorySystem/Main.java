package Lab3_InventorySystem;
import java.util.Scanner;

public class Main {
    static void displayChoices(){
        System.out.println("Options:");
        System.out.println("\t[1] Add Single Product");
        System.out.println("\t[2] Add Box Product");
        System.out.println("\t[3] Exit");

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("== INVENTORY SYSTEM ==");

        boolean isRunning = true;

        while (isRunning){
            displayChoices();

            System.out.print("Choice: ");
            String input = sc.nextLine();
            if (input.matches("\\d+")){
                int option = Integer.parseInt(input);

                if (!(option == 1 || option == 2 || option == 3)){
                    System.out.println("Your choice is out of service. Try again.");
                }
            }
            else{
                System.out.println("Invalid input. Try again.");
            }
        }

    }

}
