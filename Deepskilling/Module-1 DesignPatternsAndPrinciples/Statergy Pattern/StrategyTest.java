package strategy;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("4111111111111234"));
        context.executePayment(120.00);

        System.out.println("Customer switches payment method at checkout...");
        context.setStrategy(new PayPalPayment("shopper@example.com"));
        context.executePayment(45.50);
    }
}
