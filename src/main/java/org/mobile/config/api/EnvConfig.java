package org.mobile.config.api;

import java.util.Properties;

public record EnvConfig(Service1Config service1,
                        Service2Config service2) {

    public static EnvConfig fromProperties(Properties properties) {
        return new EnvConfig(
                new Service1Config(properties.getProperty("service1.url")),
                new Service2Config(properties.getProperty("service2.url"))
        );
    }

}
