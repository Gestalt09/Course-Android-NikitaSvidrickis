package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class BookingsView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My trips']")
    private MobileElement myTripsTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in to your account']")
    private MobileElement signInWarningTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']/following-sibling::android.view.View")
    private MobileElement profileButton;

    public BookingsView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public boolean bookingsViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(myTripsTextBox)).isDisplayed();
    }
    public boolean userNotSignedIn(){
        return new WebDriverWait(driver,GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInWarningTextBox)).isDisplayed();
    }
    public void clickProfileButton(){profileButton.click();}
}
