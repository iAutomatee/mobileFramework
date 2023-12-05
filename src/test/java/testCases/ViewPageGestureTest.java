package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.android.ViewsPage;


public class ViewPageGestureTest extends BaseTest {

    ViewsPage viewsPage;


    @Test(enabled = true)
    public void dragAndDropDemo() throws InterruptedException {
        viewsPage = homePage.clickOnViews();
        viewsPage.clickOnDragAndDrop();
        viewsPage.dragAndDrop();
        Thread.sleep(10000);
        Assert.assertTrue(viewsPage.verifyDragAndDrop());
    }

    @Test(enabled = true)
    public void swipeDemo() {
        viewsPage = homePage.clickOnViews();
        viewsPage.clickOnGallery();
        viewsPage.clickOnPhotos();
        Assert.assertTrue(viewsPage.verifySwipe());
    }

    @Test(enabled = true)
    public void scrollDemo() {
        viewsPage = homePage.clickOnViews();
        Assert.assertTrue(viewsPage.verifyScroll());
    }


    @Test(enabled = true)
    public void longPressDemo() {
        viewsPage = homePage.clickOnViews();
        viewsPage.clickExpandableList();
        viewsPage.clickCustomAdapter();
        Assert.assertTrue(viewsPage.verifyLongPress());
//        String z = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.Toast[1]")).getText();
//        Assert.assertEquals(z, "People Names: Group 0 clicked");
    }
}
