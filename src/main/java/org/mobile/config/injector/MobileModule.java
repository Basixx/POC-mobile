package org.mobile.config.injector;

import com.google.inject.AbstractModule;
import org.mobile.config.driver.AndroidDriverProvider;
import org.mobile.config.driver.IosDriverProvider;
import org.mobile.config.driver.MobileDriver;
import org.mobile.screen.element.AndroidLocator;
import org.mobile.screen.element.IosLocator;
import org.mobile.screen.element.Locator;
import org.mobile.screen.main.AndroidMainScreen;
import org.mobile.screen.main.IosMainScreen;
import org.mobile.screen.main.MainScreen;

public class MobileModule extends AbstractModule {

    private static final String PLATFORM = "ios";

    @Override
    protected void configure() {
        String platform = System.getProperty("platform", PLATFORM);
        switch (platform) {
            case "android" -> {
                bind(MobileDriver.class).to(AndroidDriverProvider.class);
                bind(Locator.class).to(AndroidLocator.class);
                bind(MainScreen.class).to(AndroidMainScreen.class);
            }
            case "ios" -> {
                bind(MobileDriver.class).to(IosDriverProvider.class);
                bind(Locator.class).to(IosLocator.class);
                bind(MainScreen.class).to(IosMainScreen.class);
            }
            default -> throw new RuntimeException("Unsupported platform: " + platform);
        }
    }

}
