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
        for (Product product : productList) {
            System.out.println(product);
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
        Integer userChoice = View.getNumberInput();

        Integer listSize = productList.size();
        while (!(userChoice < listSize)) {
            printErrorMessage();
        }

        Product product = productList.get(userChoice - 1);

        return product;
    }

    public static ProductCategory chooseCategory() {
        showCategories();
        Integer userChoice = View.getNumberInput();

        ArrayList<ProductCategory> categoryList = ProductCategory.getAllCategories();
        Integer listSize = categoryList.size();
        while (!(userChoice < listSize)) {
            printErrorMessage();
        }

        ProductCategory category = categoryList.get(userChoice - 1);

        return category;
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
        Float defaultPrice = 2.5f;
        return defaultPrice;
    }

    public static void showOrder(String status, Basket basket) {
        System.out.println("Status: " + status);
        basket.showBasket();
        if (basket.getProductList().size() > 0) {
            Boolean checkout = View.getDecision();
            if (checkout) {
                order.changeStatus();
            }
        } else {
            View.emptyBasket();
        }
    }

    public static Boolean getDecision() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to checkout your order? (y/n): ");

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
}