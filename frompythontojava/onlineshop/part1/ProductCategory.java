package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class ProductCategory {

    private static ArrayList<ProductCategory> categoryList = new ArrayList<>();
    private static Integer id = 1;

    private String name;
    private Integer ID;

    public ProductCategory() {

    }
    
    public ProductCategory(String name) {
        this.name = name;
        this.ID = id++;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Category: %s, id: %d", name, ID);
    }

    public static ArrayList<ProductCategory> getAllCategories() {
        return categoryList;
    }
}