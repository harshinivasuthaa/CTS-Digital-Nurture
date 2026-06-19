package proxy;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading \"" + filename + "\" from remote server... (expensive!)");
        try {
            Thread.sleep(300); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\"" + filename + "\" loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying \"" + filename + "\".");
    }
}
