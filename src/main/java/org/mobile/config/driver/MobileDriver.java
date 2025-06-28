package org.mobile.config.driver;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface MobileDriver {

    AppiumDriver createDriver() throws MalformedURLException, URISyntaxException;

}
