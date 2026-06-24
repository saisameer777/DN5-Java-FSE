public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting application...");
        logger2.log("Processing data...");

        if (logger1 == logger2) {
            System.out.println("Both references point to the same Logger instance.");
        } else {
            System.out.println("Different instances - Singleton failed.");
        }
    }
}
