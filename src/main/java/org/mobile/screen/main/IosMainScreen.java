package org.mobile.screen.main;

import com.google.inject.Inject;
import org.mobile.screen.element.ElementWrapper;
import org.mobile.screen.element.Locator;

public class IosMainScreen extends MainScreen {

    @Inject
    public IosMainScreen(Locator locator) {
        super(locator);
        this.mainElement = new ElementWrapper(locator.byAutomator("**/XCUIElementTypeStaticText[`name == \"contact alert\"`]"));
        this.secondElement = new ElementWrapper(locator.byAccId("Access'ibility"));
    }

}
