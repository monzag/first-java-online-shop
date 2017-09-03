package frompythontojava.onlineshop.part1;
import java.util.Date;;

public class FeaturedProductCategory extends ProductCategory {

    private Date exspirationDate;

    public FeaturedProductCategory(String name, Date exspirationDate) {
        super(name);
        this.exspirationDate = exspirationDate;
    }

    public Date getExspirationDate() {
        return exspirationDate;

    }
}