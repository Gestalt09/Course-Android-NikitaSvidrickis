package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SignInView {

    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue as a guest']/following-sibling::android.widget.Button")
    private MobileElement continueAsAGuestButton;

    public SignInView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public boolean signInViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(continueAsAGuestButton)).isDisplayed();
    }

    public void clickContinueAsAGuestButton() {
        continueAsAGuestButton.click();
    }
}
