package frompythontojava.onlineshop.part2;

public class Order implements Orderable {

    private static Integer id = 1;
    private String status;
    private Integer ID;

    public Order() {
        this.status = "new";
        this.ID = id++;
    }

    public String getStatus() {
        return status;
    }
    public boolean checkout() {
        if (status.equals("new")) { 
            status = "checked";
            return true;
        } else {
            return false;
        }
    }

    public boolean pay() {
        if (status.equals("checked")) { 
            status = "payed";
            return true;
        } else {
            return false;
        }
    }
}