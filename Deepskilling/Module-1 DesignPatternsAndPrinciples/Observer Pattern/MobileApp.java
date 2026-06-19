package observer;

public class MobileApp implements Observer {
    private final String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println("[MobileApp - " + userName + "] Push notification: "
                + symbol + " is now $" + price);
    }
}
