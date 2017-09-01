package frompythontojava.onlineshop.part1;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {

    public ArrayList<Product> productList;

    public Basket() {
        this.productList = new ArrayList<Product>();
    }

    public ProductIterator getIterator() {
        return new ProductIterator();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Boolean removeProduct(Product product) {
        
        for (ProductIterator iter = this.getIterator(); iter.hasNext(); ) {
            Product productInlist = (Product)iter.next();
            if (product.equals(productInlist)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    public class ProductIterator implements Iterator {

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