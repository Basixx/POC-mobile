package org.mobile.screen.element;

import static io.appium.java_client.AppiumBy.iOSClassChain;

public class IosLocator extends Locator {

    public Locator byAutomator(String locator) {
        Locator finder = new IosLocator();
        finder.searchStrategy = driver -> driver.findElement(iOSClassChain(locator));
        return finder;
    }

}
