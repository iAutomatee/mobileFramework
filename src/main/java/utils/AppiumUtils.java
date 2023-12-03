package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils {

    public AppiumDriver driver;
    WebDriverWait wait;

    public AppiumUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToAppear(WebElement ele) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

}
