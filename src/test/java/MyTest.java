import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MyTest extends BaseTest {

    @Test(enabled = false)
    public void appiumTest(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//*[contains(@text,'3. Preference dependencies')]")).click();
        WebElement title = driver.findElement(By.xpath("//*[contains(@text,'Example preference dependency')]"));
        Assert.assertTrue(title.isDisplayed());
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//*[contains(@text,'WiFi settings')]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Test");
        String getWiFiTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(getWiFiTitle, "WiFi settings");
        driver.findElement(By.xpath("//*[contains(@text,'OK')]")).click();


    }

    @Test
    public void appiumTestt(){
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//*[contains(@text,'3. Preference dependencies')]")).click();
//        WebElement title = driver.findElement(By.xpath("//*[contains(@text,'Example preference dependency')]"));
//        Assert.assertTrue(title.isDisplayed());
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//*[contains(@text,'WiFi settings')]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Test");
        String getWiFiTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(getWiFiTitle, "WiFi settings");
        driver.findElement(By.xpath("//*[contains(@text,'OK')]")).click();
    }


}
