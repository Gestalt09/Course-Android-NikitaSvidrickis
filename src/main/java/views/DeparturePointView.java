package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class DeparturePointView {

    protected AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='From:']")
    private MobileElement fromTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement departureSearchBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skopje, Republic of North Macedonia']")
    private MobileElement skopjeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose']/following-sibling::android.widget.Button")
    private MobileElement chooseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Riga, Latvia']")
    private MobileElement rigaButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Clear All']")
    private MobileElement clearAllButton;

    public DeparturePointView(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean departurePointViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(fromTextBox)).isDisplayed();
    }
    public void clickOnClearAllButton(){
        clearAllButton.click();
    }
    public void searchForCity(String city){
        departureSearchBar.clear();
        departureSearchBar.sendKeys(city);
    }

    public void clickOnSkopje(){skopjeButton.click();}
    public void clickOnChooseButton(){
        chooseButton.click();
    }
    public void clickOnRiga(){rigaButton.click();}




}
