package proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("vacation_photo.png");

        System.out.println("\nCalling display() for the 1st time:");
        image.display();

        System.out.println("\nCalling display() for the 2nd time:");
        image.display();

        System.out.println("\nCalling display() for the 3rd time:");
        image.display();
    }
}
