package org.mobile.screen.element;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mobile.config.injector.GuiceInjector;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

public abstract class Locator {

    protected Function<AppiumDriver, WebElement> searchStrategy;

    public abstract Locator byAutomator(String locator);

    public Function<AppiumDriver, WebElement> getSearchStrategy() {
        return searchStrategy;
    }

    public Locator byAccId(String accId) {
        Locator finder = GuiceInjector.get().getInstance(this.getClass());
        finder.searchStrategy = driver -> driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId(accId));
        return finder;
    }

}
