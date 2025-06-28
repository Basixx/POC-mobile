package org.mobile.config.driver;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.mobile.config.exception.ScreenshotException;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DriverActions {

    private final DriverManager driverManager;

    @Inject
    public DriverActions(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void resetApp() {
        if (driverManager.isDriverRunning()) {
            driverManager.getDriver().resetCooldown();
        }
    }

    public void reportScreenShot(String screenshotName) {
        takeScreenshotWithLabel(driverManager.getDriver(), screenshotName);
    }

    private void takeScreenshotWithLabel(AppiumDriver driver, String screenshotName) {
        File screenShot = driver.getScreenshotAs(OutputType.FILE);

        try {
            Path path = Paths.get("screenshots", screenshotName + ".png");
            Files.createDirectories(path.getParent());
            Files.move(screenShot.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ScreenshotException("Failed to save screenshot: " + screenshotName, e);
        }

    }

}
