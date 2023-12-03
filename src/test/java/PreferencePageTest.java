import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.android.PreferencesPage;

public class PreferencePageTest extends BaseTest {

    PreferencesPage preferencesPage;

    @Test(enabled = true)
    public void verifyExamplePreferenceDependenciesLabel() {
        preferencesPage = homePage.clickOnPreference();
        preferencesPage.clickOnPreferenceDependencies();
        preferencesPage.verifyDependencyOption();
    }


    @Test(enabled = true)
    public void verifyWiFiSettingLabel() {
        preferencesPage = homePage.clickOnPreference();
        preferencesPage.clickOnPreferenceDependencies();
        preferencesPage.clickOnCheckbox();
        preferencesPage.clickOnWiFiSettings();
        Assert.assertTrue(preferencesPage.verifyWiFiName("WiFi settings"));
    }




}
