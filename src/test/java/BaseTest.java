import org.amarthatest.BaseSetup;
import org.amarthatest.listener.AllureTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.amarthatest.constant.DataConstant.BASE_URL;

@Listeners(AllureTestListener.class)
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
