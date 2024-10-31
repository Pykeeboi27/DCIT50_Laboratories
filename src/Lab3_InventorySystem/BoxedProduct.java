package Lab3_InventorySystem;

public class BoxedProduct {

    String brand;
    int quantity;

    BoxedProduct(String brand, int quantity){
        this.brand = brand;
        this.quantity = quantity;

        System.out.println("Boxed Product has been added!");
    }

    String getBrand(){
        return this.brand;
    }

    int getQuantity(){
        return this.quantity;
    }
}
