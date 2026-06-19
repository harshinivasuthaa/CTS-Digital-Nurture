package observer;

public class WebApp implements Observer {
    @Override
    public void update(String symbol, double price) {
        System.out.println("[WebApp] Dashboard updated: " + symbol + " = $" + price);
    }
}
