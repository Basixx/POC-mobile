package org.mobile.config.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidDriverProvider implements MobileDriver {

    @Override
    public AppiumDriver createDriver() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("10")
                .setDeviceName("Pixel_9_Pro")
                .setAutomationName("UiAutomator2")
                .setUdid("emulator-5554")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
                .setApp("/Users/barbararomecka/Downloads/ApiDemos-debug.apk")
                .setFullReset(true);
        URI uri = new URI("http://localhost:4723");
        return new AndroidDriver(uri.toURL(), options);
    }

}
