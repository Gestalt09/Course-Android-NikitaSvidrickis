import org.testng.annotations.Test;
import org.testng.Assert;
import util.DriverSetup;

public class Departure extends DriverSetup {
    @Test(testName ="Android Tasks")
    public void continueAsAGuest() {

        Assert.assertTrue(signInView.signInViewLoaded(),"Sign in view isn't loaded");
        signInView.clickContinueAsAGuestButton();

        Assert.assertTrue(onboardingStepOneView.onboardingStepOneViewLoaded(),"Onboarding step one view isn't loaded");
        onboardingStepOneView.clickDeparturePickerButton();

        Assert.assertTrue(departurePointView.departurePointViewLoaded(),"Departure point view isn't loaded");
        departurePointView.searchForCity("Skopje");
        departurePointView.clickOnSkopje();
        departurePointView.clickOnChooseButton();

        Assert.assertTrue(onboardingStepOneView.onboardingStepOneViewLoaded(),"Onboarding step one view isn't loaded");
        onboardingStepOneView.clickContinueButton();

        Assert.assertTrue(onboardingStepTwoView.onboardingStepTwoViewLoaded(),"Onboarding step two view isn't loaded");
        onboardingStepTwoView.clickCurrencyPickerButton();

        Assert.assertTrue(currencyPickerView.departurePointViewLoaded(),"Currency picker view isn't loaded");
        currencyPickerView.searchForCurrency("CHF");
        currencyPickerView.selectCurrency("CHF");

        Assert.assertTrue(onboardingStepTwoView.onboardingStepTwoViewLoaded(),"Onboarding step two view isn't loaded");
        onboardingStepTwoView.clickContinueButton();

        Assert.assertTrue(onboardingStepThreeView.onboardingStepThreeViewLoaded(),"Onboarding step three view isn't loaded");
        onboardingStepThreeView.clickEuropeButton();
        onboardingStepThreeView.clickContinueButton();

        Assert.assertTrue(onboardingStepFourView.onboardingStepFourViewLoaded(),"Onboarding step four view isn't loaded");
        onboardingStepFourView.clickExploreTheAppButton();

        Assert.assertTrue(homePageView.homepageViewLoaded(),"Home page view isn't loaded");

        Assert.assertTrue(homePageView.validateFieldFrom(),"Field - from isn't correct");

        homePageView.clickBookingsButton();

        Assert.assertTrue(bookingsView.bookingsViewLoaded(),"Bookings view isn't loaded");
        Assert.assertTrue(bookingsView.userNotSignedIn(),"User is not loged off");

        bookingsView.clickProfileButton();

        Assert.assertTrue(profileView.profileViewLoaded(),"Profile view isn't loaded");
        profileView.clickAppPreferencesButton();

        Assert.assertTrue(appPreferencesView.appPreferencesViewLoaded(),"App preferneces view isn't loaded");
        Assert.assertTrue(appPreferencesView.currencyCHFLoaded(),"Wrong currency");

        appPreferencesView.clickDefaultCityBox();

        Assert.assertTrue(departurePointView.departurePointViewLoaded(),"Departure point view isn't loaded");
        departurePointView.clickOnClearAllButton();
        departurePointView.searchForCity("Riga");
        departurePointView.clickOnRiga();
        departurePointView.clickOnChooseButton();

        Assert.assertTrue(appPreferencesView.appPreferencesViewLoaded(),"App preferneces view isn't loaded");
        Assert.assertTrue(appPreferencesView.cityRigaLoaded(),"Default departure location is not Riga");












    }
}
