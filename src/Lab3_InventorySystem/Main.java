package Lab3_InventorySystem;
import java.util.Scanner;

public class Main {
    static void displayChoices(){
        //This method displays all option available in the inventory manager
        System.out.println("\nOptions:");
        System.out.println("\t[1] Add Single Product");
        System.out.println("\t[2] Add Box Product");
        System.out.println("\t[3] Exit");
    }

    static int getOption(Scanner sc){
        //This method gets the user's choice from the choices of display choices
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
                createSingleProduct(sc, inventory);
            }

            else if (option == 2){
                createBoxedProduct(sc, inventory);
            }

            else if (option == 3){
                isRunning = false;
                inventoryReport(inventory);
            }

        }
    }

    static void createSingleProduct(Scanner sc, InventoryManager inventory){
        boolean isValid = false;
        int quantity = 0;
        String brand = "";

        while (!isValid) {
            System.out.print("Brand: ");
            brand = sc.nextLine();

            if (brand.isBlank()){
                System.out.println("Brand must have a name.");
            }
            else{
                isValid = true;
            }
        }

        isValid = false;
        while (!isValid){
            System.out.print("Quantity: ");
            String input = sc.nextLine();

            if (input.matches("\\d+")){
                quantity = Integer.parseInt(input);

                if (quantity <= 0){
                    System.out.println("Must be at least 1 quantity. Try Again.");
                }
                else{
                    isValid = true;
                }
            }
            else{
                System.out.println("Invalid input. Try again.");
            }
        }

        //Initialization of single product and adding it to the inventory
        SingleProduct prod = new SingleProduct(brand);
        if(quantity > 1) {
            inventory.add(prod,quantity);
        }
        else{
            inventory.add(prod);
        }
    }

    static void createBoxedProduct(Scanner sc, InventoryManager inventory){
        boolean isValid = false;
        int quantity = 0;
        int items = 0;
        String brand = "";

        while(!isValid) {
            System.out.print("Brand: ");
            brand = sc.nextLine();

            if (brand.isBlank()){
                System.out.println("Brand must have a name.");
            }
            else{
                isValid = true;
            }
        }

        isValid = false;
        while (!isValid) {
            System.out.print("Items in box: ");
            String input1 = sc.nextLine();

            //Error handling for getting the items in the box
            if (input1.matches("\\d+")) {
                quantity = Integer.parseInt(input1);

                if (quantity <= 0) {
                    System.out.println("Must be at least 1 item in the box. Try Again.");
                } else {
                    isValid = true;
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        isValid = false;
        while (!isValid) {
            System.out.print("Quantity: ");
            String input2 = sc.nextLine();

            //Error handling for getting quantity of boxes
            if (input2.matches("\\d+")){
                quantity = Integer.parseInt(input2);

                if (quantity <= 0){
                    System.out.println("Must be at least 1 quantity. Try Again.");
                }
                else{
                    isValid = true;
                }
            }
            else{
                System.out.println("Invalid input. Try again.");
            }
        }

        //Initialization of boxed product and adding it to the inventory
        BoxedProduct prod = new BoxedProduct(brand, items);
        if(quantity > 1) {
            inventory.add(prod,quantity);
        }
        else{
            inventory.add(prod);
        }
    }

    static void inventoryReport(InventoryManager inv){

        System.out.println("\n-Inventory Report-");
        for (String brand: inv.brands){
            int brandTotalPieces = 0;
            int singlesTotal = 0;
            int boxesTotal = 0;

            if (brand == null){
                break;
            }

            for (SingleProduct p: inv.singles){
                if (p == null){
                    break;
                }
                else if (p.getBrand().equalsIgnoreCase(brand)){
                    singlesTotal ++;
                    brandTotalPieces ++;
                }
            }

            for (BoxedProduct p: inv.boxes){
                if (p == null){
                    break;
                }
                else if (p.getBrand().equalsIgnoreCase(brand)){
                    boxesTotal ++;
                    brandTotalPieces += p.getQuantity();
                }
            }


            System.out.println("\n" + brand);
            System.out.println("\tSingles: " + singlesTotal);
            System.out.println("\tBoxes: " + boxesTotal);
            System.out.println("\tTotal Pieces: " + brandTotalPieces);
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InventoryManager inventory = new InventoryManager();

        System.out.println("== INVENTORY SYSTEM ==");
        inventoryProgram(sc, inventory);
    }

}
