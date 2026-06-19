package adapter;

public class StripeGateway {
    public void makeCharge(double amount, String currencyCode) {
        System.out.println("StripeGateway: charged " + amount + " " + currencyCode + " via Stripe.");
    }
}
