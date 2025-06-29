package org.mobile.config.injector;

import com.google.inject.AbstractModule;
import org.mobile.config.api.EnvConfig;
import org.mobile.config.exception.EnvironmentException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentModule extends AbstractModule {

    private static final Environment ENVIRONMENT = Environment.TEST;

    @Override
    protected void configure() {
        String env = System.getProperty("env", ENVIRONMENT.name().toLowerCase());
        String fineName = env + ".properties";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fineName)) {
            Properties properties = new Properties();
            properties.load(input);
            EnvConfig envConfig = EnvConfig.fromProperties(properties);
            bind(EnvConfig.class).toInstance(envConfig);
        } catch (IOException e) {
            throw new EnvironmentException("Failed to load environment config: " + fineName, e);
        }
    }

}
