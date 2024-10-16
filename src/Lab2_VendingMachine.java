
import java.util.Scanner;

public class Lab2_VendingMachine {

    public static int initialBalance(Scanner sc){
        //This method asks for the user's balance to be spent in the shop
        int bal = 0;

        while (true) { //Loop is used to check if user input is valid
            System.out.print("Enter your initial balance: ");
            String input = sc.nextLine();

            if (input.matches("\\d+")){  //Checks if input is a whole number
                bal = Integer.parseInt(input);

                //Outputs if user's input is less than 15 since the cheapest item in the shop is $15
                if (bal < 15){
                    System.out.println("You must have a balance of at least $15. Try again.");
                }
                else{ //User's input is valid and breaks out of the loop
                    break;
                }
            }

            else{ //Outputs if user's input is not a whole number
                System.out.println("Your balance must be whole positive numbers with no " +
                        "decimals or letters. Try again.");
            }
        }
        return bal;
    }

    public static void displayMenu(){
        //This method displays the products available in the shop
        System.out.println("\nAvailable items:");
        System.out.println("1. Soda - $25");
        System.out.println("2. Chips - $15");
        System.out.println("3. Chocolate - $20");
    }

    public static int userOrder(Scanner sc){
        //This method asks for the user's order based on the shop's menu
        int choice;

        while(true){ //Loop is used to check if user input is valid
            System.out.print("Enter the item number you want to buy: ");
            String input = sc.nextLine();

            if (input.matches("\\d+")){ //Checks if input is a whole number
                choice = Integer.parseInt(input);

                //Outputs if user's input is not equal to 1, 2, or 3
                if (!(choice == 1 || choice == 2 || choice == 3)){
                    System.out.println("Invalid input. Try again. ");
                }
                else{ //User's input is valid and breaks out of the loop
                    break;
                }
            }

            else{ //Outputs if user's input is not a whole number
                System.out.println("Invalid input. Try again. ");
            }
        }

        /* Deducts 1 from the user's input since we'll use the choice variable to access
           an element from the PRICES array in the main method */
        return choice -= 1;
    }

    public static int canBuy(int[] prices, int balance, int order, Scanner sc){
        //This method checks if the user has enough money to buy their choice from the shop

        //Checks if the order's price is greater than the balance
        //Loops to ask for another input if condition in the loop is met
        while(prices[order] > balance){
            System.out.println("You don't have enough money to buy this product. Try again.");
            order = userOrder(sc);
        }

        //Deducts the order's price from the user's balance and prints out remaining balance
        balance -= prices[order];
        System.out.println("\nItem purchased successfully. " +
                "Your remaining balance is $" + balance + ".");
        return balance;
    }

    public static boolean willStillShop(Scanner sc){
        //This method asks if the user will still shop if they have enough balance to buy more

        //Asks for user's input and converts it to all low caps
        System.out.print("Do you want to buy another item? (yes/no): ");
        String action = sc.nextLine().toLowerCase();

        //Catches if the user doesn't input a yes or a no
        //Loops to ask for another input
        while (!(action.equals("yes") || action.equals("no"))){
            System.out.println("Invalid Input! Try again.");
            System.out.print("Do you want to buy another item? (yes/no): ");
            action = sc.nextLine().toLowerCase();
        }

        //returns true if yes, and false if no
        return action.equals("yes");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] PRICES = {25, 15, 20}; //Item prices in order

        System.out.println("=== WELCOME TO THE VENDING MACHINE ===");
        int balance = initialBalance(sc); //gets balance through initialBalance() method
        boolean shopping = true;

        //Main Loop
        while(shopping){
            displayMenu(); //displays menu
            int input = userOrder(sc); //asks for user's order

            //checks if user's order can be bought using canBuy() method
            //if user has enough money, the item's price will be deducted
            balance = canBuy(PRICES, balance, input, sc);

            if (balance == 0){ //checks if user has run out of money
                System.out.println("You have no remaining balance. Ending purchase.");
                //breaks out of the main loop
                shopping = false;
            }
            else{ //checks if user has enough money to buy any more products
                boolean canStillBuy = false;

                /* loops checks all prices and if the balance is greater than or equal to
                   any of the items then the user can still buy more */
                for (int price: PRICES){
                    if (balance >= price){
                        canStillBuy = true;
                        break;
                    }
                }

                if (!canStillBuy){
                    System.out.println("You don't have sufficient funds to buy any more items. Ending purchase.");
                    shopping = false; //breaks out off main loop
                }
                else{ //asks user if they still want to buy more if they have any more money
                    shopping = willStillShop(sc);
                }
            }

        }
        System.out.println("\nThank you for using the vending machine!");
        System.out.println("=== END ===");

        sc.close();
    }
}
