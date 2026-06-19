package adapter;

public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amountInUsd) {
        stripeGateway.makeCharge(amountInUsd, "USD");
    }
}
