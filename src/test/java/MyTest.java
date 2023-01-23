import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MyTest {
    @Test
    public void appiumTest() throws MalformedURLException, InterruptedException {
        URL url = new URL("http://127.0.0.1:4723");
        String appPath = "/Users/vinayrana/Documents/Automation_Code_And_Framework/src/test/resources/ApiDemos-debug.apk";
        String mainJs = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";
        File mainFile = new File(mainJs);


        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel_3a_API_32_arm64-v8a");
        uiAutomator2Options.setApp(appPath);
        AndroidDriver driver = new AndroidDriver(url, uiAutomator2Options);
        Thread.sleep(10000);
        driver.quit();

        //Start Appium Server
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder().withAppiumJS(mainFile);


    }

}
