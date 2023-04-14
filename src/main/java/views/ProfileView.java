package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

public class ProfileView extends Helpers {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
    private MobileElement inboxButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App preferences']")
    private MobileElement appPreferencesbutton;

    public ProfileView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean profileViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(inboxButton)).isDisplayed();
    }
    public void clickAppPreferencesButton(){
        scrollToElementWithText(driver,"App preferences");
        appPreferencesbutton.click();
    }
}
