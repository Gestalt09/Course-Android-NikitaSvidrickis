package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepThreeView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Where would you like to go?']")
    private MobileElement whereWouldYouLikeToGoTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Europe \uD83D\uDC30']")
    private MobileElement europeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']/following-sibling::android.widget.Button")
    private MobileElement continueButton;

    public OnboardingStepThreeView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public boolean onboardingStepThreeViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(whereWouldYouLikeToGoTextBox)).isDisplayed();
    }

    public void clickEuropeButton(){europeButton.click();}

    public void clickContinueButton(){continueButton.click();}
}
