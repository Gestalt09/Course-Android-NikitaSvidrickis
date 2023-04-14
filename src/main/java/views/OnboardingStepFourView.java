package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class OnboardingStepFourView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You’re ready for your next adventure']")
    private MobileElement youAreReadyForYourNextAdventureTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore the app']/following-sibling::android.widget.Button")
    private MobileElement exploreTheAppButton;

    public OnboardingStepFourView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean onboardingStepFourViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(youAreReadyForYourNextAdventureTextBox)).isDisplayed();
    }

    public void clickExploreTheAppButton(){exploreTheAppButton.click();}
}
