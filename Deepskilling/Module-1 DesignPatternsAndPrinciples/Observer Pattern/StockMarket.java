package observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String symbol;
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }
    
    public void setPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        System.out.println("\n[StockMarket] " + symbol + " price changed to $" + price);
        notifyObservers();
    }
}
