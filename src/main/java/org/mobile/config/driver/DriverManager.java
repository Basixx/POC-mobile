package org.mobile.config.driver;

import io.appium.java_client.AppiumDriver;
import org.mobile.config.exception.DriverException;
import org.mobile.config.injector.GuiceInjector;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> DRIVER_HOLDER = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        if (!isDriverRunning()) {
            try {
                DRIVER_HOLDER.set(GuiceInjector.get().getInstance(MobileDriver.class).createDriver());
            } catch (Exception e) {
                throw new DriverException("Failed to create driver", e);
            }
        }
        return DRIVER_HOLDER.get();
    }

    public boolean isDriverRunning() {
        return DRIVER_HOLDER.get() != null;
    }

}
