package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepTwoView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What’s your currency?']")
    private MobileElement whatIsYourCurrencyTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Currency']/following-sibling::android.view.View/android.widget.TextView")
    private MobileElement currencyPickerButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']/following-sibling::android.widget.Button")
    private MobileElement continueButton;

    public OnboardingStepTwoView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public boolean onboardingStepTwoViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(whatIsYourCurrencyTextBox)).isDisplayed();
    }

    public void clickCurrencyPickerButton() {
        currencyPickerButton.click();
    }
    public void clickContinueButton(){continueButton.click();}
}
