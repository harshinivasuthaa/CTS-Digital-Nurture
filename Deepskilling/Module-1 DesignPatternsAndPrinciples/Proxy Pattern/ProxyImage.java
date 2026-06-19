package proxy;

public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
        System.out.println("ProxyImage created for \"" + filename + "\" (no loading yet).");
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); 
        } else {
            System.out.println("(Using cached image for \"" + filename + "\" - no reload.)");
        }
        realImage.display();
    }
}
