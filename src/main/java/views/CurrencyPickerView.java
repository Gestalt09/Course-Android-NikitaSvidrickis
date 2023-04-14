package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class CurrencyPickerView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "picker_container")
    private MobileElement currencyPickerContainer;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement searchBar;

    public CurrencyPickerView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean departurePointViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(currencyPickerContainer)).isDisplayed();
    }

    public void searchForCurrency(String currency) {
        searchBar.clear();
        searchBar.sendKeys(currency);
    }

    public void selectCurrency(String currency) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(driver.findElementByXPath(String.format("//android.widget.TextView[contains(@text, '%s')]", currency)))).click();
    }
}
