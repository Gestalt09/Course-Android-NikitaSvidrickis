package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepOneView {

    protected AndroidDriver<MobileElement> driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Where do you start your trips?']")
    private MobileElement whereToStartYourTripsTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preferred departure']/following-sibling::android.view.View/android.widget.TextView")
    private MobileElement departurePickerButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']/following-sibling::android.widget.Button")
    private MobileElement continueButton;

    public OnboardingStepOneView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean onboardingStepOneViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(whereToStartYourTripsTextBox)).isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
    public void clickDeparturePickerButton(){departurePickerButton.click();}
}
