package Lab5_EmployeeManagementSystem;

import java.util.Scanner;

public class Main {

    public static void displayChoices(){
        System.out.println("Menu:");
        System.out.println("1. Add a new employee");
        System.out.println("2. Display all employees");
        System.out.println("3. Exit");
    }

    public static boolean program(Scanner sc){
        displayChoices();


        return true;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
    }
}
