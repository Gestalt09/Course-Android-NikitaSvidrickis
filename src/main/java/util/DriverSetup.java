package util;

import org.testng.annotations.Listeners;
import views.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup {

    public static AndroidDriver<MobileElement> driver;

    protected Helpers helpers;

    protected SignInView signInView;
    protected OnboardingStepOneView onboardingStepOneView;
    protected DeparturePointView departurePointView;
    protected OnboardingStepTwoView onboardingStepTwoView;
    protected CurrencyPickerView currencyPickerView;
    protected OnboardingStepThreeView onboardingStepThreeView;
    protected OnboardingStepFourView onboardingStepFourView;
    protected HomePageView homePageView;
    protected BookingsView bookingsView;
    protected ProfileView profileView;
    protected AppPreferencesView appPreferencesView;

    public DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        capabilities.setCapability("avd", "Pixel_5_API_32");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/nikitasvidrickis/Downloads/kiwi.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.kiwi.android.feature.splash.impl.ui.SplashActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.skypicker.main");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver<>(new URL(GlobalVariables.localAppiumServerUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        helpers = new Helpers();

        signInView = new SignInView(driver);
        onboardingStepOneView = new OnboardingStepOneView(driver);
        departurePointView = new DeparturePointView(driver);
        onboardingStepTwoView = new OnboardingStepTwoView(driver);
        currencyPickerView = new CurrencyPickerView(driver);
        onboardingStepThreeView = new OnboardingStepThreeView(driver);
        onboardingStepFourView = new OnboardingStepFourView(driver);
        homePageView = new HomePageView(driver);
        bookingsView = new BookingsView(driver);
        profileView = new ProfileView(driver);
        appPreferencesView = new AppPreferencesView(driver);
    }
}
