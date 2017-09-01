package frompythontojava.onlineshop.part2;

public class CheckoutProcess extends AbstractProcess {

    @Override
    public void action(Orderable item) {
        item.checkout();
    }
}