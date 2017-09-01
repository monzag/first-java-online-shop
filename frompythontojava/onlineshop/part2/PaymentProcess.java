package frompythontojava.onlineshop.part2;

public class PaymentProcess extends AbstractProcess {

    @Override
    public void action(Orderable item) {
        item.pay();
    }
}