package org.amarthatest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSetup {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void setup(String chromeVersion) {
        WebDriverManager.chromedriver().driverVersion(chromeVersion).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
