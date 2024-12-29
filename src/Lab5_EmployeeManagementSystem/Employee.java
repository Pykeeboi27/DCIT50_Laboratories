package Lab5_EmployeeManagementSystem;

public class Employee {

    private int id;
    private String name;
    private double salary;

    //Getter for ID
    public int getId(){
        return id;
    }

    //Setter for ID
    public void setId(int id){
        if (id > 0){
            this.id = id;
        }
        else{
            System.out.println("Error: ID must be a positive integer.");
        }
    }

    //Getter for name
    public String getName(){
        return name;
    }

    //Setter for name
    public void setName(String name){
        if (name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else{
            System.out.println("Error: Name cannot be empty.");
        }
    }

    //Getter for salary
    public double getSalary(){
        return salary;
    }

    //Getter for salary
    public void setSalary(double salary){
        if (salary > 0){
            this.salary = salary;
        }
        else{
            System.out.println("Error: Salary must be a positive number.");
        }
    }
}
