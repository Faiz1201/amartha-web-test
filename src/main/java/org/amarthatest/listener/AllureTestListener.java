package org.amarthatest.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class AllureTestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object webDriverAttribute = iTestResult.getTestContext().getAttribute("WebDriver");

        if (webDriverAttribute instanceof WebDriver) {
            WebDriver driver = (WebDriver) webDriverAttribute;
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            saveScreenshot(driver);
        } else {
            System.out.println("WebDriver Can't Be Found.");
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object webDriverAttribute = iTestResult.getTestContext().getAttribute("WebDriver");

        if (webDriverAttribute instanceof WebDriver) {
            WebDriver driver = (WebDriver) webDriverAttribute;
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            saveScreenshot(driver);
        } else {
            System.out.println("WebDriver Can't Be Found.");
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Path path = Path.of("allure-results/screenshot_" + System.currentTimeMillis() + ".png");
            Files.write(path, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }
}

