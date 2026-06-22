public class LoggerTest {
    public static void main(String[] args) {

        // Get instance twice
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use them
        logger1.log("Starting application...");
        logger2.log("Processing data...");

        // Prove both variables point to same object
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both are the SAME instance! Singleton works.");
        } else {
            System.out.println("FAILED: Different instances created!");
        }
    }
}
