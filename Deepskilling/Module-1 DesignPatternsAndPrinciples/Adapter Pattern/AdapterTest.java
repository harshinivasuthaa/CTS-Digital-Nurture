package adapter;

public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor[] processors = {
            new PayPalAdapter(new PayPalGateway()),
            new StripeAdapter(new StripeGateway())
        };

        for (PaymentProcessor processor : processors) {
            processor.processPayment(49.99);
        }
    }
}
