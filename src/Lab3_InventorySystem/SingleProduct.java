package Lab3_InventorySystem;

public class SingleProduct {

    String brand;
    int quantity;

    SingleProduct(String brand){
        this.brand = brand;
        this.quantity = 1;
    }

    SingleProduct(String brand, int quantity){
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getBrand(){
        return this.brand;
    }


}
