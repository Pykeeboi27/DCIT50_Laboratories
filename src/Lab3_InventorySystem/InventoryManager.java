package Lab3_InventorySystem;

import java.util.Locale;

public class InventoryManager {

    //PROPERTIES
    String[] brands = new String[100]; //Stores all brands inputted by the user
    int brandsCounter = 0; //assignment of a brand to an index (increases in the methods)

    BoxedProduct[] boxes = new BoxedProduct[1000]; //Stores all boxed products created by the user;
    int boxesCounter = 0; //assignment of a BoxedProduct object to an index (increases in the methods)

    SingleProduct[] singles = new SingleProduct[1000]; //Stores all single products created by the user;
    int singlesCounter = 0; //assignment of a SingleProduct object to an index (increases in the methods)


    //BEHAVIORS
    boolean isArrayFull(Object[] array) {
        //Checks if an array is full
        for (Object element : array) {
            if (element == null) { // Checking for unassigned (null) elements
                return false;
            }
        }
        return true; // All elements are assigned
    }

    private void brandAdd(SingleProduct p){
        //adding brand if still not in list - for Single Products
        boolean isExistingBrand = false;

        if (!isArrayFull(brands)) {
            for (String brand : brands) {
                //If any of the strings in the "brands" array equals to the SingleProduct's brand then it exits out of the loop and the function does nothing
                if (p.getBrand().equalsIgnoreCase(brand)) {
                    isExistingBrand = true;
                    break;
                }
                //Breaks out of the loop it reaches the null values of the array
                else if (brand == null) {
                    break;
                }
            }

            //If any of the strings in the "brands" array doesn't equal to the SingleProduct's brand then it adds it to the array.
            if (!isExistingBrand) {
                brands[brandsCounter] = p.getBrand();
                brandsCounter++;
            }
        }
        else{
            System.out.println("Unable to add anymore brands. Inventory system can only have 100 brands.");
        }
    }

    private void brandAdd(BoxedProduct p){
        //adding brand if still not in list - for Boxed Products
        boolean isExistingBrand = false;

        for (String brand: brands){
            //If any of the strings in the "brands" array equals to the user's input then it exits out of the loop and the function does nothing
            if (p.getBrand().equalsIgnoreCase(brand)){
                isExistingBrand = true;
                break;
            }
            //Breaks out of the loop it reaches the null values of the array
            else if(brand == null){
                break;
            }
        }

        //If any of the strings in the "brands" array doesn't equal to the SingleProduct's brand then it adds it to the array.
        if (!isExistingBrand){
            brands[brandsCounter] = p.getBrand();
            brandsCounter ++;
        }
    }

    void add(SingleProduct p){
        //Adds one individually packed product to the inventory
        singles[singlesCounter] = p;
        singlesCounter ++; //Increases the array's counter
        brandAdd(p); //Checks if the brand of the object already exists
    }

    void add(SingleProduct p, int quantity){
        //Adds the specified number of individually packed product to the inventory
        for(int i = 0; i < quantity; i++){
            singles[singlesCounter] = p;
            singlesCounter ++; //Increases the array's counter
        }
        brandAdd(p); //Checks if the brand of the object already exists
    }

    void add(BoxedProduct p){
        //Adds one box to the inventory
        boxes[boxesCounter] = p;
        boxesCounter ++; //Increases the array's counter
        brandAdd(p); //Checks if the brand of the object already exists
    }

    void add(BoxedProduct p, int quantity){
        //Adds the specified number of boxes to the inventory
        for(int i = 0; i < quantity; i++){
            boxes[boxesCounter] = p;
            boxesCounter ++; //Increases the array's counter
        }
        brandAdd(p); //Checks if the brand of the object already exists
    }

    String[] getBrands(){
        //Returns all brands in the inventory
        return brands;
    }

    BoxedProduct[] getBoxes(String brand){
        //Returns the array containing all the boxes for a given brand
        return boxes;
    }

    SingleProduct[] getSingles(String brand){
        //Returns the array containing all individually packaged item for the given brand
        return singles;
    }
}
