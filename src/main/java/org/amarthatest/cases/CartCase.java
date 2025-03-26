package org.amarthatest.cases;

import io.qameta.allure.Step;
import org.amarthatest.utils.ElementAction;
import org.openqa.selenium.By;

public class CartCase {
    private static By btnItemName(String text) {
        return By.xpath("//div[text()='"+text+"']");
        //Sauce Labs Backpack
    }
    private static final By btnAddToCart = By.id("add-to-cart");
    private static final By btnCartCheckout = By.id("shopping_cart_container");
    private static By btnInventoryItemName() {
        return By.xpath("//div[@data-test='inventory-item-name']");
    }

    public static void addToCartItem(String itemName) {
        ElementAction.click(btnItemName(itemName));
        ElementAction.click(btnAddToCart);
    }

    public static void verifyCheckoutItem(String text) {
        ElementAction.click(btnCartCheckout);
        ElementAction.validateText(btnInventoryItemName(), text);
    }
}
