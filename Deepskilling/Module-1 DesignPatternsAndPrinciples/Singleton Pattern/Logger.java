package singleton;

public class Logger {

    private static volatile Logger instance;

    private static int instancesCreated = 0;

    private Logger() {
        instancesCreated++;
        if (instancesCreated > 1) {
            throw new IllegalStateException("Logger instance already created!");
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static int getInstancesCreatedCount() {
        return instancesCreated;
    }
}
