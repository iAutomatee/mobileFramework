package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

import java.util.List;


public class ViewsPage extends AndroidActions {

    AndroidDriver driver;


    @AndroidFindBy(accessibility = "Gallery")
    private WebElement gallery;
    @AndroidFindBy(accessibility = "1. Photos")
    private WebElement photos;
    @AndroidFindBy(accessibility = "Drag and Drop")
    private WebElement dragAndDrop;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement source;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_2")
    private WebElement target;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement result;
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement image1;
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
    private WebElement image2;
    @AndroidFindBy(accessibility = "WebView")
    private List<WebElement> webView;

    @AndroidFindBy(accessibility = "Expandable Lists")
    private WebElement expandableLists;

    @AndroidFindBy(accessibility = "(1. Custom Adapter")
    private WebElement customAdapter;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    private WebElement peopleNames;
    @AndroidFindBy(id = "android:id/title")
    private List<WebElement> title;


    public ViewsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnGallery() {
        gallery.click();
    }

    public void clickOnPhotos() {
        photos.click();
    }

    public void clickOnDragAndDrop() {
        dragAndDrop.click();
    }

    public void dragAndDrop() {
        //drag
        dragAndDropAction(source, target);
    }

    public String getResultText() {
        return result.getText();
    }

    public boolean verifyDragAndDrop() {
        dragAndDrop();
        return (result.getText().equalsIgnoreCase("Dropped!"));
    }

    public boolean verifySwipe() {
        String focus = "";
        //Swipe
        swipeAction(image1, "left");
        focus = image2.getAttribute("focusable");
        Assert.assertEquals("true", focus);
        return (focus.equalsIgnoreCase("true"));
    }

    public boolean verifyScroll() {
        scrollAction("WebView");
        return (!webView.isEmpty());
    }

    public void clickExpandableList() {
        expandableLists.click();
    }

    public void clickPeopleNames() {
        peopleNames.click();
    }

    public void clickCustomAdapter() {
        customAdapter.click();
    }

    public boolean verifyLongPress() {
        longPressAction(peopleNames, 2000);
        String s = title.get(0).getText();
        return (s.equalsIgnoreCase("Sample menu"));

    }
}
