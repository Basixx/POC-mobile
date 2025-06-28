package org.mobile.screen.main;

import com.google.inject.Inject;
import org.mobile.screen.BaseScreen;
import org.mobile.screen.element.ElementWrapper;
import org.mobile.screen.element.Locator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class MainScreen extends BaseScreen {

    protected ElementWrapper mainElement;

    protected ElementWrapper secondElement;

    @Inject
    public MainScreen(Locator locator) {
        super(locator);
    }

    public void findMainElement() {
        assertTrue(mainElement.isDisplayed());
        assertTrue(secondElement.isDisplayed());
    }

}
