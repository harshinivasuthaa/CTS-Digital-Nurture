package adapter;

public class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPalGateway: sent payment of $" + amount + " via PayPal.");
    }
}
