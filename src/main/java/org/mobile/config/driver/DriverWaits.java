package org.mobile.config.driver;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Supplier;

public class DriverWaits {

    private final Duration timeout = Duration.ofSeconds(60);

    private final Duration pollingInterval = Duration.ofMillis(500);

    private final DriverManager driverManager;

    @Inject
    public DriverWaits(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void waitFor(Supplier<Boolean> condition, String message) {
        waitFor(condition, message, timeout, pollingInterval);
    }

    private void waitFor(Supplier<Boolean> condition,
                         String message,
                         Duration timeout,
                         Duration pollingInterval) {
        try {
            FluentWait<AppiumDriver> wait = new FluentWait<>(driverManager.getDriver())
                    .withTimeout(timeout)
                    .pollingEvery(pollingInterval);
            wait.until(driver -> condition.get());
        } catch (Exception e) {
            throw new RuntimeException(message, e);
        }
    }

}
