import com.google.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mobile.screen.main.MainScreen;

public class OpenAppTest extends BaseTest {

    @BeforeEach
    public void before() {
        beforeTest(this);
    }

    @Inject
    private MainScreen mainScreen;

    @Test
    public void openApp() {
        mainScreen.findMainElement();
    }

    @AfterEach
    public void after() {
        afterTest("OpenAppTest");
    }

}
