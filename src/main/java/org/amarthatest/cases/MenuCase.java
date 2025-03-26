package org.amarthatest.cases;

import io.qameta.allure.Step;
import org.amarthatest.model.ListMenu;
import org.amarthatest.utils.ElementAction;
import org.openqa.selenium.By;

public class MenuCase {
    private static final By btnBurger = By.id("react-burger-menu-btn");

    public static void goToListMenu(ListMenu listMenu) {
        ElementAction.click(btnBurger);
        switch (listMenu) {
            case ALL_ITEMS:
                ElementAction.click(By.id("inventory_sidebar_link"));
                break;
            case ABOUT:
                ElementAction.click(By.id("about_sidebar_link"));
                break;
            case LOGOUT:
                ElementAction.click(By.id("logout_sidebar_link"));
                break;
            case RESET_APP_STATE:
                ElementAction.click(By.id("reset_sidebar_link"));
                break;
        }
    }
}
