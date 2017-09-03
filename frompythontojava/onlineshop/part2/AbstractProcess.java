package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess {

    public void process(Orderable item) {
        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {
        System.out.println("Your order:");
    }

    public abstract void action(Orderable item);

    public void stepAfter() {
        System.out.println("We send you e-mail with payment details. Thank you for order!");
    }
}