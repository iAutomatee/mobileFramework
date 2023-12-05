package testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.android.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    String ipAddress = "127.0.0.1";
    String port = "4723";
    URL url;
    //URL url = new URL("http://127.0.0.1:4723/wd/hub");
    public static AndroidDriver driver;
    String appPath = "/Users/vinayrana/Documents/Automation_Code_And_Framework/src/test/resources/ApiDemos-debug.apk";
    String mainJs = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";
    File mainFile = new File(mainJs);
    File nodeFile = new File("/usr/local/bin/node");
    UiAutomator2Options uiAutomatorOptions;
    HomePage homePage;
    AppiumDriverLocalService serviceBuilder;
    Properties pro = new Properties();
    private static AppiumDriverLocalService server;

//    public void configureAppium() throws MalformedURLException {
//        System.out.println("Appium Configuration Started");
//        url = new URL("http://" + ipAddress + ":" + port + "/wd/hub/");
//        serviceBuilder = new AppiumServiceBuilder()
//                .withIPAddress(ipAddress).usingPort(Integer.parseInt(port))
//                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/").build();
//
//        UiAutomator2Options uiAutomatorOptions = new UiAutomator2Options();
//        uiAutomatorOptions.setDeviceName("Pixel_3a_API_32_arm64-v8a");
//        uiAutomatorOptions.setApp(appPath);
//        driver = new AndroidDriver(url, uiAutomatorOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//
//    }


    public AppiumDriverLocalService getAppiumService() {

        if (checkIfServerIsRunnning(Integer.parseInt(port))) {
            System.out.println("Appium server is already Running........");
            server.stop();
        }

        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(nodeFile).withAppiumJS(mainFile).usingPort(Integer.parseInt(port)).withArgument(GeneralServerFlag.SESSION_OVERRIDE));
    }


    @BeforeMethod(alwaysRun = true)
    public void startAppiumServer() {
        driverSetup();
        server = getAppiumService();
        server.start();
        System.out.println("Appium server started......");

    }

    public void driverSetup() {
        uiAutomatorOptions = new UiAutomator2Options();
        uiAutomatorOptions.setDeviceName("Pixel_3a_API_32_arm64-v8a");
        uiAutomatorOptions.setApp(appPath);
        driver = new AndroidDriver(uiAutomatorOptions);
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }


    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    public void stopAppiumServer() {
//        serviceBuilder.stop();
        server.stop();
        System.out.println("Server Stopped");
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        stopAppiumServer();
    }

    public String getProperty(String key) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("src/main/java/resources/data.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            pro.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pro.getProperty(key);
    }


}
