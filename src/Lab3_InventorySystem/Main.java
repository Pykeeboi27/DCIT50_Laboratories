package Lab3_InventorySystem;
import java.util.Scanner;
import Lab3_InventorySystem.*;

public class Main {
    static void displayChoices(){
        System.out.println("\nOptions:");
        System.out.println("\t[1] Add Single Product");
        System.out.println("\t[2] Add Box Product");
        System.out.println("\t[3] Exit");

    }

    static int getOption(Scanner sc){

        boolean isValid = false;
        int option = 0;

        while (!isValid) {
            System.out.print("Choice: ");
            String input = sc.next();
            if (input.matches("\\d+")) {
                option = Integer.parseInt(input);

                if (!(option == 1 || option == 2 || option == 3)) {
                    System.out.println("Your choice is out of service. Try again.");
                }
                else{
                    isValid = true;
                }

            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return option;
    }

    static void inventoryReport(){
        System.out.println("\n-Inventory Report-\n");
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("== INVENTORY SYSTEM ==");

        boolean isRunning = true;

        while (isRunning){
            displayChoices();

            int option = getOption(sc);
            if (option == 1){
                System.out.print("Brand: ");
                String brand = sc.next();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                SingleProduct singleProduct = new SingleProduct(brand);
            }

            if (option == 2){
                System.out.print("Brand: ");
                String brand = sc.next();

                System.out.print("Items in box: ");
                int items = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                BoxedProduct boxedProduct = new BoxedProduct(brand, items);
            }


            else if (option == 3){
                isRunning = false;
                inventoryReport();
            }

        }

    }

}
