package Lab3_InventorySystem;

public class BoxedProduct {

    //PROPERTIES
    String brand;
    int quantity;

    //BEHAVIORS
    BoxedProduct(String brand, int quantity){
        //Class Constructor
        this.brand = brand;
        this.quantity = quantity;
    }

    String getBrand(){
        //This method returns the brand of the BoxedProduct object
        return this.brand;
    }

    int getQuantity(){
        //This method returns the amount of items inside the BoxedProduct object
        return this.quantity;
    }
}
