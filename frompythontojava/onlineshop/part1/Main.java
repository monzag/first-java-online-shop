package frompythontojava.onlineshop.part1;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
    
        ProductCategory category = new ProductCategory("books");
        System.out.println(category.getName());

        Product product = new Product("Winds of winter", 25.5f, category);
        System.out.println(product);
        System.out.println(product.toString());
        System.out.println(product.getAllProducts());
        System.out.println(product.getAllProductsBy(category));

        Date date = new Date(2017, 10, 10);
        FeaturedProductCategory featuredCategory = new FeaturedProductCategory("SuperBooks", date);
        System.out.println(featuredCategory);
        System.out.println(featuredCategory.getExspirationDate());

        Basket basket = new Basket();
        System.out.println(basket.getProductList());
        basket.addProduct(product);
        System.out.println(basket.getProductList());
        basket.removeProduct(product);
        System.out.println(basket.getProductList());

        }
}
