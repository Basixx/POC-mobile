package org.mobile.screen.main;

import com.google.inject.Inject;
import org.mobile.screen.element.ElementWrapper;
import org.mobile.screen.element.Locator;

public class AndroidMainScreen extends MainScreen {

    @Inject
    public AndroidMainScreen(Locator locator) {
        super(locator);
        this.mainElement = new ElementWrapper(locator.byAutomator("Access'ibility"));
        this.secondElement = new ElementWrapper(locator.byAccId("App"));
    }

}
