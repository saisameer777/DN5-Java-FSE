public class Logger {

    // Step 1: Private static instance - only one will ever exist
    private static Logger instance;

    // Step 2: Private constructor - nobody outside can call new Logger()
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public static method to get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Step 4: Actual logger functionality
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
