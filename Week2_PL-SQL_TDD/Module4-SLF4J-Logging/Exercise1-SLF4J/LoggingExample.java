import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.trace("Trace level message");
        logger.debug("Debug level message");
        logger.info("Application started successfully");
        logger.warn("Low disk space warning");
        logger.error("Database connection failed");

        String username = "john_doe";
        int attempts = 3;
        logger.warn("User {} failed to login after {} attempts", username, attempts);
        logger.error("Account locked for user: {}", username);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Exception occurred: {}", e.getMessage(), e);
        }

        logger.info("Application finished.");
    }
}
