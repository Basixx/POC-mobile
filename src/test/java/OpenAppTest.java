import com.google.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mobile.domain.operations.ClientOperations;
import org.mobile.screen.main.MainScreen;

public class OpenAppTest extends BaseTest {

    @BeforeEach
    public void before() {
        beforeTest(this);
    }

    @Inject
    private MainScreen mainScreen;

    @Inject
    private ClientOperations clientOperations;

    @Test
    public void openApp() {
        mainScreen.findMainElement();
        clientOperations.callService1();
        clientOperations.callService2();
    }

    @AfterEach
    public void after() {
        afterTest("OpenAppTest");
    }

}
