package listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.amarthatest.BaseSetup.driver;

public class AllureTestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        if (driver != null) {
            saveScreenshot(driver);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (driver != null) {
            saveScreenshot(driver);
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        try {
            if (driver != null) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil screenshot: " + e.getMessage());
        }
        return new byte[0];
    }
}

