package Lab5_EmployeeManagementSystem;

import java.util.*;

public class Main {

    public static void displayChoices(){
        System.out.println("\nMenu:");
        System.out.println("1. Add a new employee");
        System.out.println("2. Display all employees");
        System.out.println("3. Exit");
    }

    public static void displayEmployees(ArrayList<Employee> Employees){
        if(Employees.isEmpty()){
            System.out.println("No employees to display.");
        }
        else{
            System.out.println("\nEmployee Details: ");
            for (Employee e: Employees){
                System.out.println("ID: " + e.getId());
                System.out.println("Name: " + e.getName());
                System.out.println("Salary: $" + e.getSalary());
                System.out.println("------------------------------");
            }

        }
    }

    public static boolean idIsUnique(int id, ArrayList<Employee> Employees){
        for (Employee e: Employees){
            if (e.getId() == id){
                return false;
            }
        }
        return true;
    }

    public static boolean nameIsUnique(String name, ArrayList<Employee> Employees){
        for (Employee e: Employees){
            if (e.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }

    public static void addEmployee(Scanner sc, ArrayList<Employee> Employees){

        Employee employee = new Employee();

        do{
            try{
                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                while (!idIsUnique(id, Employees)){
                    System.out.println("Error: ID is already associated with an employee. Try again.");
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                }
                employee.setId(id);
                break;

            }
            catch(Exception e){
                sc.nextLine();
                System.out.println("Error: Can only take numbers. Try again.");
            }
        }while(true);


        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        while (!nameIsUnique(name, Employees)){
            System.out.println("Error: Person is already an employee. Try again.");
            System.out.print("Enter Employee Name: ");
            name = sc.nextLine();
        }
        employee.setName(name);

        do{
            try{
                System.out.print("Enter Employee Salary: ");
                double salary = sc.nextDouble();

                employee.setSalary(salary);
                break;
            }
            catch(Exception e){
                sc.nextLine();
                System.out.println("Error: Can only take numbers. Try again.");
            }
        }while(true);

        if(employee.getId() != 0 && employee.getName() != null && employee.getSalary() != 0){
            Employees.add(employee);
            System.out.println("Employee Successfully Added!");
        }
        else{
            System.out.println("Error: Failed to add employee. Please try again.");
        }
    }

    public static void program(Scanner sc, ArrayList<Employee> Employees){

        do {
            try {
                displayChoices();
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                while (!(choice == 1 || choice == 2 || choice == 3)) {
                    System.out.println("Error: Can only take integers 1-3.\n");
                    System.out.print("Choose an option: ");
                    choice = sc.nextInt();
                }
                if(choice == 1){
                    addEmployee(sc, Employees);
                }
                else if(choice == 2){
                    displayEmployees(Employees);
                }
                else {
                    System.out.println("Exiting Program.");
                    break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Error: Can take integers 1-3.");
            }
        }while(true);

    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> Employees= new ArrayList<Employee>();

        program(sc, Employees);
        sc.close();
    }
}
