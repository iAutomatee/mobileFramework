package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils{
    public AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }


    public void longPressAction(WebElement ele, int durationSeconds) {
        JavascriptExecutor javascriptExecutor = driver;
        javascriptExecutor.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", durationSeconds));
    }

    public void scrollAction(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void swipeAction(WebElement ele, String direction) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
    }

    public void dragAndDropAction(WebElement ele, WebElement target) {
        int leftX = target.getLocation().getX();
        int upperY = target.getLocation().getY();
        int x = (leftX + target.getSize().width) / 2;
        int y = upperY + (target.getSize().height) / 2;

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "endX", x, "endY", y));
    }

    public void goToHome() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void goBack() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


}
