import com.google.inject.Inject;
import org.mobile.config.driver.DriverActions;
import org.mobile.config.injector.GuiceInjector;

import java.util.logging.Logger;

import static java.lang.invoke.MethodHandles.lookup;

public abstract class BaseTest {

    protected static final Logger LOGGER = Logger.getLogger(lookup().lookupClass().getName());

    @Inject
    protected DriverActions driverActions;

    protected void beforeTest(BaseTest test) {
        GuiceInjector.get().injectMembers(test);
        driverActions.resetApp();
    }

    protected void afterTest(String testName) {
        GuiceInjector.reset();
        driverActions.reportScreenShot(testName);
    }

}
