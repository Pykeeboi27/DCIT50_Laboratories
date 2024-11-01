package Lab3_InventorySystem;

public class SingleProduct {

    //PROPERTY
    String brand;

    //BEHAVIORS
    SingleProduct(String brand){
        //Class Constructor
        this.brand = brand;
    }

    String getBrand(){
        //This method returns the brand of the SingleProduct object
        return this.brand;
    }


}
