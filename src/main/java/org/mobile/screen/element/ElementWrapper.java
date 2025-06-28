package org.mobile.screen.element;

import com.google.inject.Inject;
import org.mobile.config.driver.DriverManager;
import org.mobile.config.driver.DriverWaits;
import org.mobile.config.injector.GuiceInjector;
import org.openqa.selenium.WebElement;

public class ElementWrapper {

    private final Locator locator;

    @Inject
    private DriverManager driverManager;

    @Inject
    private DriverWaits driverWaits;

    private WebElement webElement;

    public ElementWrapper(Locator locator) {
        GuiceInjector.get().injectMembers(this);
        this.locator = locator;
    }

    public boolean isDisplayed() {
        return find().webElement.isDisplayed();
    }

    public ElementWrapper find() {
        driverWaits.waitFor(this::exists, "Element not found");
        return this;
    }

    public boolean exists() {
        webElement = locator.getSearchStrategy().apply(driverManager.getDriver());
        return webElement != null;
    }

}
