package frompythontojava.onlineshop.part1;
import java.util.ArrayList;

public class Product {

    private static Integer id = 1;
    private static ArrayList<Product> productList = new ArrayList<>();

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    
    public Product() {
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = id++;
    }

    public String toString() {
        String info;
        if (productCategory instanceof FeaturedProductCategory) {
            info = String.format("FeaturedProductCategory,ID:%d,name:%s,defaultprice:%f,productCategory:%s", ID, name, defaultPrice, productCategory.getName());
        } else {
            info = String.format("ID:%d,name:%s,defaultprice:%f,productCategory:%s", ID, name, defaultPrice, productCategory.getName());
        }
        return info;
    }

    public static ArrayList getAllProducts() {
        return productList;
    }

    public static ArrayList getAllProductsBy(ProductCategory productCategory) {
        ArrayList<Product> sameCategory = new ArrayList<>();
        for (Product product : productList) {
            if (product.productCategory.equals(productCategory)) {
                sameCategory.add(product);
            }
        }
        return sameCategory;
    }
}