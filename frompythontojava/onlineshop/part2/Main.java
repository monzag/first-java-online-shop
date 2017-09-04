package frompythontojava.onlineshop.part2;

public class Main {

    public static void main(String[] args) {
	
    Order order = new Order();
    System.out.println(order.getStatus());
    order.checkout();
    System.out.println(order.getStatus());
    order.pay();
    System.out.println(order.getStatus());

    CheckoutProcess checkout = new CheckoutProcess();
    checkout.process(order);

    PaymentProcess payment = new PaymentProcess();
    payment.process(order);

    }
}
