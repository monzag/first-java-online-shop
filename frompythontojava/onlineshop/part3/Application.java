package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part1.FeaturedProductCategory;
import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;
import frompythontojava.onlineshop.part2.Order;

import java.util.ArrayList;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        Basket basket = new Basket();

        Boolean work = true;

        while (work) {
            View.displayMainMenu();
            String userChoice = View.getUserInput();

            if (userChoice.equals("1")) {
                createNewProduct();

            } else if (userChoice.equals("2")) {
                createNewCategory();

            } else if (userChoice.equals("3")) {
                addProductToBasket(basket);

            } else if (userChoice.equals("4")) {
                basket.showBasket();

            } else if (userChoice.equals("5")) {
                // remove product from basket.
                ;
            } else if (userChoice.equals("6")) {
                getAllAvailableProducts();

            } else if (userChoice.equals("7")) {
                getProductsByCategory();

            } else if (userChoice.equals("8")) {
                checkProduct();

            } else if (userChoice.equals("9")) {
                payForOrder(basket);

            } else if (userChoice.equals("0")) {
                View.printExitMessage();
                work = false;
            } else {
                View.printErrorMessage();
            }
        }
    }

    public static void createNewProduct() {
        String name = View.getProductName();
        Float defaultPrice = View.getDefaultPrice();
        ProductCategory category = View.chooseCategory();
        Product product = new Product(name, defaultPrice, category);
        ArrayList<Product> productList = Product.getAllProducts();
        productList.add(product);
    }

    public static void createNewCategory() {
        ProductCategory category = getNewCategory();
        ArrayList<ProductCategory> categoryList = ProductCategory.getAllCategories();
        categoryList.add(category);
    }

    public static ProductCategory getNewCategory() {
        ProductCategory category;
        String userChoice = View.getTypeCategory();
        String name = View.getCategoryName();

        // Options: 1 - product category, 2 - Featured product category
        if (userChoice.equals("1")) {
            category = new ProductCategory(name);

        } else {
            Date date = new Date(2017, 10, 10);
            category = new FeaturedProductCategory(name, date);
        }

        System.out.println("Done");

        return category;

    }

    public static void addProductToBasket(Basket basket) {
        Product product = View.chooseProduct();
        basket.addProduct(product);
    }

    public static void getAllAvailableProducts() {
        ArrayList<Product> productList = Product.getAllProducts();
        View.showProducts(productList);
    }

    public static void getProductsByCategory() {
        String name = View.getCategoryName();
        ProductCategory category = new ProductCategory(name);
        ArrayList<Product> sameCategory = Product.getAllProductsBy(category);
        View.showProducts(sameCategory);
    }

    public static void checkProduct() {
        ArrayList<Product> findProducts = new ArrayList<>();
        String search = View.getProductName();
        ArrayList<Product> productList = Product.getAllProducts();
        for (Product product : productList) {
            String name = product.getName();
            if (name.toLowerCase().contains(search)) {
                findProducts.add(product);
            }
        }
        View.showProducts(findProducts);
    }

    public static void payForOrder(Basket basket) {
        Order order = new Order();
        String status = order.getStatus();
        View.showOrder(status, basket);
        if (basket.getProductList().size() > 0) {
            Boolean continues = View.getDecision();
            if (continues) {
                order.checkout();
                basket.getTotalPrice();
            }

        } else {
            View.emptyBasket();
        }
    }
}
