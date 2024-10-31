package Lab3_InventorySystem;

public class BoxedProduct {

    //PROPERTIES
    String brand;
    int quantity;

    //BEHAVIORS
    BoxedProduct(String brand, int quantity){
        this.brand = brand;
        this.quantity = quantity;
    }

    String getBrand(){
        return this.brand;
    }

    int getQuantity(){
        return this.quantity;
    }
}
