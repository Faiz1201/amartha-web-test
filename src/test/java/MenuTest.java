import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listener.AllureTestListener;
import org.amarthatest.cases.MenuCase;
import org.amarthatest.model.ListMenu;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestListener.class)
public class MenuTest extends BaseTest {
    LoginTest loginTest = new LoginTest();

    @Test
    @Description("Automate login flow, click on hamburger button (top left), navigate to 'About' and verify if it successfully navigated or not")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Do Login")
    public void checkMenuAbout() {
        loginTest.doValidLogin();
        MenuCase.goToListMenu(ListMenu.ABOUT);
    }
}
