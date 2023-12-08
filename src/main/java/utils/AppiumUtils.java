package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppiumUtils {

    public AppiumDriver driver;
    WebDriverWait wait;


    public void waitForElementToAppear(WebElement ele) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public String captureScreenshot(String testCaseName,AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/target/reports/index.html";
        String destination = System.getProperty("user.dir") + "src/test/resources/screenshots/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;

    }

}
