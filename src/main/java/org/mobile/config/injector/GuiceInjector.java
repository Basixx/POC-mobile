package org.mobile.config.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceInjector {

    private static final ThreadLocal<Injector> INJECTOR_HOLDER = new ThreadLocal<>();

    private GuiceInjector() {
    }

    public static Injector get() {
        if (INJECTOR_HOLDER.get() == null) {
            INJECTOR_HOLDER.set(Guice.createInjector(
                    new MobileModule(),
                    new EnvironmentModule()
            ));
        }
        return INJECTOR_HOLDER.get();
    }

    public static void reset() {
        INJECTOR_HOLDER.remove();
    }

}
