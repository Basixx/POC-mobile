package org.mobile.screen;

import com.google.inject.Inject;
import org.mobile.screen.element.Locator;

public class BaseScreen {

    public Locator locator;

    @Inject
    public BaseScreen(Locator locator) {
        this.locator = locator;
    }

}
