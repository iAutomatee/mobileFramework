package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class HomePage extends AndroidActions {
    AndroidDriver driver;
    @AndroidFindBy(accessibility = "Views")
    private WebElement views;
    @AndroidFindBy(accessibility = "Preference")
    private WebElement preference;

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ViewsPage clickOnViews() {
        views.click();
        return new ViewsPage(driver);
    }

    public PreferencesPage clickOnPreference() {
        preference.click();
        return new PreferencesPage(driver);
    }

}
