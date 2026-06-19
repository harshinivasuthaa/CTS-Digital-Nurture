package singleton;

public class LoggerTest {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("Processing request from a different part of the app.");

        System.out.println("logger1 hashcode: " + System.identityHashCode(logger1));
        System.out.println("logger2 hashcode: " + System.identityHashCode(logger2));
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
        System.out.println("Total Logger instances ever created: " + Logger.getInstancesCreatedCount());

        if (logger1 == logger2 && Logger.getInstancesCreatedCount() == 1) {
            System.out.println("PASS: Singleton pattern correctly enforced.");
        } else {
            System.out.println("FAIL: More than one instance exists!");
        }
    }
}
