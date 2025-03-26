import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listener.AllureTestListener;
import org.amarthatest.cases.CartCase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestListener.class)
public class CartTest extends BaseTest {
    LoginTest loginTest = new LoginTest();
    private static final String item_backpack = "Sauce Labs Backpack";
    private static final String item_fleece_jacket = "Sauce Labs Fleece Jacket";

    @Test
    @Description("Automate login flow, add 'Sauce Labs Backpack' to cart and verify that correct item is added to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Do Add To Cart")
    public void addBackPackToCart() {
        loginTest.doValidLogin();
        CartCase.addToCartItem(item_backpack);
        CartCase.verifyCheckoutItem(item_backpack);
    }

    @Test
    @Description("Automate login flow, add 'Sauce Labs Fleece Jacket' to cart and verify that correct item is added to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Do Add To Cart")
    public void addFleesJacketToCart() {
        loginTest.doValidLogin();
        CartCase.addToCartItem(item_fleece_jacket);
        CartCase.verifyCheckoutItem(item_fleece_jacket);
    }
}
