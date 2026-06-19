package observer;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer aliceApp = new MobileApp("Alice");
        Observer bobApp = new MobileApp("Bob");
        Observer dashboard = new WebApp();

        stockMarket.registerObserver(aliceApp);
        stockMarket.registerObserver(bobApp);
        stockMarket.registerObserver(dashboard);

        stockMarket.setPrice("GOOG", 2843.50);

        System.out.println("\nBob unsubscribes...");
        stockMarket.deregisterObserver(bobApp);

        stockMarket.setPrice("GOOG", 2851.10);
    }
}
