package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class HomePageView {
    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(accessibility = "Travel")
    private MobileElement travelButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bookings']/following-sibling::android.view.View")
    private MobileElement bookingsButton;

    public HomePageView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean homepageViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(travelButton)).isDisplayed();
    }
    public boolean validateFieldFrom() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElementByXPath(String.format("//android.widget.TextView[@text='From:']/following-sibling::android.widget.TextView[@text='Skopje']")))).isDisplayed();
    }
    public void clickBookingsButton(){bookingsButton.click();}
}
