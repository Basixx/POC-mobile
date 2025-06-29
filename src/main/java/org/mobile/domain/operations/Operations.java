package org.mobile.domain.operations;

import com.google.inject.Inject;
import org.mobile.config.api.EnvConfig;

public abstract class Operations {

    @Inject
    protected EnvConfig envConfig;

    protected String service1() {
        return envConfig.service1().url();
    }

    protected String service2() {
        return envConfig.service2().url();
    }

}
