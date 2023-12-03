package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class PreferencesPage extends AndroidActions {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*[contains(@text,'3. Preference dependencies')]")
    private WebElement preferenceDependencies;
    @AndroidFindBy(xpath = "//*[contains(@text,'Example preference dependency')]")
    private WebElement examplePreferenceDependency;

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement checkbox;

    @AndroidFindBy(xpath = "//*[contains(@text,'WiFi settings')]")
    private WebElement settingsWiFi;

    @AndroidFindBy(id = "android:id/edit")
    private WebElement editWifi;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitle;


    public PreferencesPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public boolean verifyDependencyOption() {
        return examplePreferenceDependency.isDisplayed();
    }

    public void clickOnPreferenceDependencies() {
        preferenceDependencies.click();
    }

    public void clickOnCheckbox() {
        checkbox.click();
    }

    public void clickOnWiFiSettings() {
        settingsWiFi.click();
    }

    public void setWiFiName(String name){
        editWifi.sendKeys(name);
    }

    public boolean verifyWiFiName(String expectedName){
       return alertTitle.getText().equalsIgnoreCase(expectedName);
    }


}
