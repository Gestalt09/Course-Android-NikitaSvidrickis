package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class AppPreferencesView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Customization']")
    private MobileElement customizationTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHF']")
    private MobileElement currencyBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skopje']")
    private MobileElement skopjeCityBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Riga']")
    private MobileElement rigaCityBox;

    public AppPreferencesView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean appPreferencesViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(customizationTextBox)).isDisplayed();
    }
    public boolean currencyCHFLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(currencyBox)).isDisplayed();
    }
    public void clickDefaultCityBox(){
        skopjeCityBox.click();
    }
    public boolean cityRigaLoaded(){
        return new WebDriverWait(driver,GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(rigaCityBox)).isDisplayed();
    }
}
