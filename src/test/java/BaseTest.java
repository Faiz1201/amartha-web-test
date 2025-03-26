import org.amarthatest.BaseSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.amarthatest.constant.DataConstant.BASE_URL;

public class BaseTest extends BaseSetup {
    @BeforeMethod
    public void testSetup() {
        setup("134.0.6998.165");
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }
}
