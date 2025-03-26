import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listener.AllureTestListener;
import org.amarthatest.cases.LoginCase;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestListener.class)
public class LoginTest extends BaseTest {
    @Test
    @Description("Login to SauceLabs Demo")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Do Login")
    public void doValidLogin() {
        LoginCase.doLogin("standard_user", "secret_sauce");
    }
}
