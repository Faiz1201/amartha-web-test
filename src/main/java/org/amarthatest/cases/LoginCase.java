package org.amarthatest.cases;

import io.qameta.allure.Step;
import org.amarthatest.BaseSetup;
import org.amarthatest.utils.ElementAction;
import org.openqa.selenium.By;

public class LoginCase {
    private static final By etUsername = By.id("user-name");
    private static final By etPassword = By.id("password");
    private static final By btnLogin = By.id("login-button");

    @Step("Do Case Login")
    public static void doLogin(String username, String password) {
        ElementAction.inputText(etUsername, username);
        ElementAction.inputText(etPassword, password);
        ElementAction.click(btnLogin);
    }
}
