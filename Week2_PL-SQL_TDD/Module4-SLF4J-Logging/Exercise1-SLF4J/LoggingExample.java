import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ============================================================
// Exercise 1: Logging Error Messages and Warning Levels
// Module 4 - SLF4J Logging Framework
// DN 5.0 Deep Skilling - Java FSE React
// ============================================================

public class LoggingExample {

    // SLF4J Logger - one per class, static and final
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        // All 5 log levels demonstrated (low → high severity)
        logger.trace("TRACE: Very detailed debugging info - lowest level");
        logger.debug("DEBUG: Debugging info for development");
        logger.info("INFO:  Application started successfully");
        logger.warn("WARN:  Low disk space - this is a WARNING message");
        logger.error("ERROR: Database connection failed - this is an ERROR message");

        System.out.println("\n--- Demonstrating parameterized logging ---");

        // Parameterized logging (avoids String concatenation overhead)
        String username = "JohnDoe";
        int    attempts = 3;
        logger.warn("User {} failed to login after {} attempts", username, attempts);
        logger.error("Account locked for user: {}", username);

        System.out.println("\n--- Simulating a real error scenario ---");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Log exception with stack trace
            logger.error("Arithmetic error occurred: {}", e.getMessage(), e);
        }

        logger.info("LoggingExample completed.");
    }
}
