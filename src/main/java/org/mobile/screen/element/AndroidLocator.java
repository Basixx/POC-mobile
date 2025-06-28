package org.mobile.screen.element;

import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class AndroidLocator extends Locator {

    public Locator byAutomator(String textPart) {
        Locator finder = new AndroidLocator();
        String finalLocator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"%s\"))".formatted(textPart);
        finder.searchStrategy = driver -> driver.findElement(androidUIAutomator(finalLocator));
        return finder;
    }

}
