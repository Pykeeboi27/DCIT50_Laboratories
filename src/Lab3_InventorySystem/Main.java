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

        //Loop is to check for any user errors
        while (!isValid) {
            System.out.print("Choice: ");
            String input = sc.nextLine();

            if (input.matches("\\d+")) {
                option = Integer.parseInt(input); //Converts the input to an integer if it matches an integer value

                if (!(option == 1 || option == 2 || option == 3)) { // Outputs if the user's input is not in the choices
                    System.out.println("Your choice is out of service. Try again.");
                }
                else{ //User input is valid
                    isValid = true;
                }

            } else { //Outputs if the user's input doesn't match an integer value
                System.out.println("Invalid input. Try again.");
            }
        }
        return option;
    }

    static void createSingleProduct(Scanner sc, InventoryManager inventory){
        //This method initialized a SingleProduct object/s and adds it to the inventory
        boolean isValid = false;
        int quantity = 0;
        String brand = "";

        //Getting the product's brand
        //Loop is for error handling
        while (!isValid) {
            System.out.print("Brand: ");
            brand = sc.nextLine();

            if (brand.isBlank()){ //Outputs if the user's input is blank
                System.out.println("Brand must have a name.");
            }
            else{ //Brand is valid
                isValid = true;
            }
        }

        isValid = false; //resets it to false so we only use one boolean for all loops

        //Getting the amount of products to add
        //Loop is for error handling
        while (!isValid){
            System.out.print("Quantity: ");
            String input = sc.nextLine();

            if (input.matches("\\d+")){ //Converts the input to an integer if it matches an integer value
                quantity = Integer.parseInt(input);

                if (quantity <= 0){ // Outputs if the quantity is less than or equal to 0
                    System.out.println("Must be at least 1 quantity. Try Again.");
                }
                else{ // Quantity is Valid
                    isValid = true;
                }
            }
            else{ //Outputs if the user's input doesn't match an integer value
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
        // This method initializes a BoxedProduct object/s and adds it to the inventory
        boolean isValid = false;
        int quantity = 0;
        int items = 0;
        String brand = "";

        // Getting the product's brand
        // Loop is for error handling
        while(!isValid) {
            System.out.print("Brand: ");
            brand = sc.nextLine();

            if (brand.isBlank()){ // Outputs if the user's input is blank
                System.out.println("Brand must have a name.");
            }
            else{ // Brand is valid
                isValid = true;
            }
        }

        isValid = false; // resets it to false so we only use one boolean for all loops

        // Getting the number of items in the box
        // Loop is for error handling
        while (!isValid) {
            System.out.print("Items in box: ");
            String input1 = sc.nextLine();

            // Converts the input to an integer if it matches an integer value
            if (input1.matches("\\d+")) {
                items = Integer.parseInt(input1);

                if (items <= 0) { // Outputs if items are less than or equal to 0
                    System.out.println("Must be at least 1 item in the box. Try Again.");
                } else { // Items are valid
                    isValid = true;
                }
            } else { // Outputs if the user's input doesn't match an integer value
                System.out.println("Invalid input. Try again.");
            }
        }

        isValid = false; // resets it to false so we only use one boolean for all loops

        // Getting the amount of boxes to add
        // Loop is for error handling
        while (!isValid) {
            System.out.print("Quantity: ");
            String input2 = sc.nextLine();

            // Converts the input to an integer if it matches an integer value
            if (input2.matches("\\d+")){
                quantity = Integer.parseInt(input2);

                if (quantity <= 0){ // Outputs if quantity is less than or equal to 0
                    System.out.println("Must be at least 1 quantity. Try Again.");
                }
                else{ // Quantity is valid
                    isValid = true;
                }
            }
            else{ // Outputs if the user's input doesn't match an integer value
                System.out.println("Invalid input. Try again.");
            }
        }

        // Initialization of boxed product and adding it to the inventory
        BoxedProduct prod = new BoxedProduct(brand, items);
        if(quantity > 1) {
            inventory.add(prod, quantity);
        }
        else{
            inventory.add(prod);
        }
    }

    static void inventoryReport(InventoryManager inv) {
        // This method generates and prints an inventory report for each brand in the inventory
        System.out.println("\n-Inventory Report-");

        // Looping through each brand in the inventory
        for (String brand: inv.brands) {
            int brandTotalPieces = 0;
            int singlesTotal = 0;
            int boxesTotal = 0;

            // If the brand is null, break out of the loop (end of brands list)
            if (brand == null) {
                break;
            }

            // Looping through each single product to count the quantities by brand
            for (SingleProduct p: inv.singles) {
                if (p == null) { // Break if we reach a null product in the list
                    break;
                }
                else if (p.getBrand().equalsIgnoreCase(brand)) { // Check if the brand matches
                    singlesTotal++; // Increment singles count for this brand
                    brandTotalPieces++; // Increment total piece count for this brand
                }
            }

            // Looping through each boxed product to count the quantities by brand
            for (BoxedProduct p: inv.boxes) {
                if (p == null) { // Break if we reach a null product in the list
                    break;
                }
                else if (p.getBrand().equalsIgnoreCase(brand)) { // Check if the brand matches
                    boxesTotal++; // Increment boxes count for this brand
                    brandTotalPieces += p.getQuantity(); // Add box quantity to total pieces
                }
            }

            // Printing the report details for each brand
            System.out.println("\n" + brand);
            System.out.println("\tSingles: " + singlesTotal);
            System.out.println("\tBoxes: " + boxesTotal);
            System.out.println("\tTotal Pieces: " + brandTotalPieces);
        }
    }

    static void inventoryProgram(Scanner sc, InventoryManager inventory) {
        // This method runs the main program loop, allowing users to manage the inventory
        boolean isRunning = true;

        while (isRunning) {  //Loop runs until the user chooses to exit

            displayChoices(); //Display available choices to the user

            int option = getOption(sc);// Get the user's selected option

            //If option is 1, prompt the user to create a single product
            if (option == 1) {
                createSingleProduct(sc, inventory);
            }

            //If option is 2, prompt the user to create a boxed product
            else if (option == 2) {
                createBoxedProduct(sc, inventory);
            }

            //If option is 3, stop the program loop and generate the inventory report
            else if (option == 3) {
                isRunning = false;
                inventoryReport(inventory);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //Initialize scanner for user input
        InventoryManager inventory = new InventoryManager(); //Initialize inventory manager to store products

        System.out.println("== INVENTORY SYSTEM ==");
        // Start the main program loop to manage inventory
        inventoryProgram(sc, inventory);

        sc.close();
    }
}
