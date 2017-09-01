package frompythontojava.onlineshop.part1;

public class ProductCategory {
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
}