package Lab3_InventorySystem;

import java.util.Locale;

public class InventoryManager {

    //PROPERTIES
    String[] brands = new String[100];
    int brandsCounter = 0;

    BoxedProduct[] boxes = new BoxedProduct[500];
    int boxesCounter = 0;

    SingleProduct[] singles = new SingleProduct[500];
    int singlesCounter = 0;


    //BEHAVIORS

    void brandAdd(SingleProduct p){
        //adding brand if still not in list
        boolean isExistingBrand = false;

        for (String brand: brands){
            if (p.getBrand().equalsIgnoreCase(brand)){
                isExistingBrand = true;
                break;
            }
            else if(brand == null){
                break;
            }
        }

        if (!isExistingBrand){
            brands[brandsCounter] = p.getBrand();
            brandsCounter ++;
        }
    }

    void brandAdd(BoxedProduct p){
        //adding brand if still not in list
        boolean isExistingBrand = false;

        for (String brand: brands){
            if (p.getBrand().equalsIgnoreCase(brand)){
                isExistingBrand = true;
                break;
            }
            else if(brand == null){
                break;
            }
        }

        if (!isExistingBrand){
            brands[brandsCounter] = p.getBrand();
            brandsCounter ++;
        }
    }

    void add(SingleProduct p){
        singles[singlesCounter] = p;
        singlesCounter ++;
        brandAdd(p);
    }

    void add(SingleProduct p, int quantity){
        for(int i = 0; i < quantity; i++){
            singles[singlesCounter] = p;
            singlesCounter ++;
        }
        brandAdd(p);
    }

    void add(BoxedProduct p){
        boxes[boxesCounter] = p;
        boxesCounter ++;
        brandAdd(p);
    }

    void add(BoxedProduct p, int quantity){
        for(int i = 0; i < quantity; i++){
            boxes[boxesCounter] = p;
            boxesCounter ++;
        }
        brandAdd(p);
    }

    String[] getBrands(){
        return brands;
    }

    BoxedProduct[] getBoxes(String brand){
        return boxes;
    }

    SingleProduct[] getSingles(String brand){
        return singles;
    }
}
