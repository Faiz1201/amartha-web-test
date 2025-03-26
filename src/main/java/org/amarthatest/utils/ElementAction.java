package org.amarthatest.utils;

import io.qameta.allure.Allure;
import org.amarthatest.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementAction extends BaseSetup {
    public static void waitUntilElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void click (By element) {
        waitUntilElement(element);
        Allure.step("Click Button " + element, () -> {
            driver.findElement(element).click();
        });
    }

    public static void inputText(By element, String text) {
        waitUntilElement(element);
        Allure.step("Input Text " + element + " : " + text, () -> {
            driver.findElement(element).sendKeys(text);
        });
    }

    public static void validateText(By element, String text) {
        waitUntilElement(element);
        String text_actual = driver.findElement(element).getText();
        Allure.step("Validate Text " + '('+ text_actual +')' + " compare with " + '(' + text + ')', () -> {
            Assert.assertEquals(text_actual, text);
        });
    }
}
