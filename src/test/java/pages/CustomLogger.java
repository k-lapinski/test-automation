package pages;

import com.aventstack.extentreports.ExtentTest;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

@Slf4j
public class CustomLogger {
    @Setter
    private static ExtentTest extentTest;

    public static void logInfo(String message) {
        log.info(message);
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    public static void logError(String message) {
        log.error(message);
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }
}
