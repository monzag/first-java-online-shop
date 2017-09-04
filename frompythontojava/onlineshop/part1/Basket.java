package frompythontojava.onlineshop.part1;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {

    private ArrayList<Product> productList;

    public Basket() {
        this.productList = new ArrayList<Product>();
    }

    public ProductIterator getIterator() {
        return new ProductIterator();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Boolean removeProduct(Product product) {
        
        for (ProductIterator iter = this.getIterator(); iter.hasNext(); ) {
            Product productInlist = (Product)iter.next();
            if (product.equals(productInlist)) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public void showBasket() {
        Integer number = 1;
        for (ProductIterator iter = this.getIterator(); iter.hasNext(); ) {
            Product productInlist = (Product)iter.next();
            System.out.println(number + ". " + productInlist);
            number++;
        }
    }

    public Float getTotalPrice() {
        Float totalPrice = 0.0f;
        for (ProductIterator iter = this.getIterator(); iter.hasNext(); ) {
            Product productInlist = (Product)iter.next();
            totalPrice += productInlist.getDefaultPrice();
        }
        return totalPrice;
    }

    private class ProductIterator implements Iterator {

        int index = 0;

        public boolean hasNext() {
            if (index < productList.size()) {
                return true;
            }
            return false;
        }

        public Product next() {
            if (this.hasNext()) {
                return productList.get(index++);
            }
            return null;
        }
    }
}