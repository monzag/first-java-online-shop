package frompythontojava.onlineshop.part1;
import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = getID();

    }

    public static Integer getID() {
        Integer ID = 1;
        return ID;
    }

    public String toString() {
        return String.format("ID:%d,name:%s,defaultprice:%f,productCategory:%s", ID, name, defaultPrice, productCategory.getName());
    }

    // public ArrayList getAllProducts() {
    //     ;
    // }

    // public ArrayList getAllProductsBy(ProductCategory productCategory) {
    //     ;
    // }
}