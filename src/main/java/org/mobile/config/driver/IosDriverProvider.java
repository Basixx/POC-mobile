package org.mobile.config.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class IosDriverProvider implements MobileDriver {

    @Override
    public AppiumDriver createDriver() throws MalformedURLException, URISyntaxException {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformName("iOS")
                .setPlatformVersion("18.5")
                .setDeviceName("iPhone 16 Pro Max")
                .setAutomationName("XCUITest")
                .setApp("/Users/barbararomecka/Downloads/TestApp.app")
                .autoAcceptAlerts()
                .setFullReset(true);
        URI uri = new URI("http://localhost:4723");
        return new IOSDriver(uri.toURL(), options);
    }

}
