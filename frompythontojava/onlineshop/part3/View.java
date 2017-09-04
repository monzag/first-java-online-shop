package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class View {

    public static String getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Your choice: ");
        String userChoice = input.next();

        return userChoice;
    }

    public static void displayMainMenu() {
        ArrayList<String> options = new ArrayList<>(Arrays.asList("Create new product", "Create new category or new featured category", "Add product to basket",
                                                             "Show basket", "Remove product from basket", "Show all available products", 
                                                             "Show products from category", "Check availability", "Payment"));

        displayOptions(options);
        System.out.println("\n0. Exit");
    }

    public static void displayOptions(ArrayList<String> options) {
        Integer number = 1;
        System.out.println(" ");
        for (String option : options) {
            System.out.println(String.format("%d. %s", number, option));
            number++;
        }
    }

    public static void printExitMessage() {
        System.out.println("\nGood bye;)");
    }

    public static void printErrorMessage() {
        System.out.println("\nBad choice");
    }

    public static void showProducts(ArrayList<Product> productList) {
        Integer number = 1;
        for (Product product : productList) {
            System.out.println(number + ". " + product);
            number++;
        }
    }

    public static String getCategoryName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Category: ");
        String userChoice = input.nextLine();

        return userChoice;
    }

    public static String getProductName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of product: ");
        String userChoice = input.nextLine();

        return userChoice;
    }

    public static String getTypeCategory() {
        ArrayList<String> options = new ArrayList<>(Arrays.asList("Normal", "Featured"));
        displayOptions(options);

        Scanner input = new Scanner(System.in);
        System.out.println("Write number (1 or 2): ");

        while (!input.hasNext("[1,2]")) {
            printErrorMessage();
            input.next();
        }
        String userChoice = input.next();

        return userChoice;
    }

    public static Product chooseProduct() {
        ArrayList<Product> productList = Product.getAllProducts();
        showProducts(productList);
        Integer listSize = productList.size();
        Integer index = getIndex(listSize);

        Product product = productList.get(index - 1);

        return product;
    }

    public static ProductCategory chooseCategory() {
        ArrayList<ProductCategory> categoryList = ProductCategory.getAllCategories();
        showCategories();
        Integer listSize = categoryList.size();
        Integer index = getIndex(listSize);

        ProductCategory category = categoryList.get(index - 1);

        return category;
    }

    public static Product chooseFromBasket(Basket basket) {
        ArrayList<Product> basketProducts = basket.getProductList();
        Integer listSize = basketProducts.size();
        Integer index = getIndex(listSize);

        Product product = basketProducts.get(index - 1);

        return product;
    }

    public static Integer getIndex(Integer listSize) {
        Integer userChoice = getNumberInput();
        
        while (userChoice > listSize) {
            printErrorMessage();
            userChoice = getNumberInput();
        }
        return userChoice;
    }

    public static void showCategories() {
        Integer number = 1;
        for (ProductCategory category : ProductCategory.getAllCategories()) {
            System.out.println(number + ". " + category);
            number++;
        }
    }

    public static Integer getNumberInput() {
        Scanner input = new Scanner(System.in);
        Integer number;

        System.out.println("Enter a number: ");
        while (!input.hasNextInt()) {
            printErrorMessage();
            input.next();
        }
        number = input.nextInt();
        return number;
    }

    public static Float getDefaultPrice() {
        Float defaultPrice = 2.2f;
        return defaultPrice;
    }

    public static void showOrder(String status, Basket basket) {
        showStatus(status);
        basket.showBasket();
        System.out.println("Checkout");
    }

    public static void showStatus(String status) {
        System.out.println("Status: " + status);
    }

    public static Boolean getDecision() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to continue? (y/n): ");

        while (!input.hasNext("[y,n]")) {
            printErrorMessage();
            input.next();
        }
        String userChoice = input.next();

        if (userChoice.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void emptyBasket() {
        System.out.println("Your basket is empty!");
    }

    public static void showPayment(Float totalPrice) {
        System.out.println("Order costs are: " + totalPrice + " zł");
    }
}