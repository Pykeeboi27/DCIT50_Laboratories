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
            String input = sc.nextLine();
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

    static void inventoryProgram(Scanner sc, InventoryManager inventory){
        boolean isRunning = true;

        while (isRunning){
            displayChoices();

            int option = getOption(sc);
            if (option == 1){
                System.out.print("Brand: ");
                String brand = sc.nextLine();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                SingleProduct prod = new SingleProduct(brand);
                if(quantity > 1) {
                    inventory.add(prod,quantity);
                }
                else{
                    inventory.add(prod);
                }
            }

            else if (option == 2){
                System.out.print("Brand: ");
                String brand = sc.nextLine();

                System.out.print("Items in box: ");
                int items = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                BoxedProduct prod = new BoxedProduct(brand, items);
                if(quantity > 1) {
                    inventory.add(prod,quantity);
                }
                else{
                    inventory.add(prod);
                }
            }

            else if (option == 3){
                isRunning = false;
                inventoryReport(inventory);
            }

        }
    }

    static void inventoryReport(InventoryManager inv){
        System.out.println("\n-Inventory Report-");
        for (String brand: inv.brands){
            if (brand == null){
                break;
            }

            System.out.println("\n" +brand);
        }

    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        InventoryManager inventory = new InventoryManager();

        System.out.println("== INVENTORY SYSTEM ==");
        inventoryProgram(sc, inventory);


    }

}
