package Lab3_InventorySystem;

public class SingleProduct {

    String brand;

    SingleProduct(String brand){
        System.out.println("Single product has been created!");
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }


}
