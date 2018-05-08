package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FilterPageTest extends Caps {

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private BookSpacePage bookSpacePage;
    private FilterPage filterPage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        bookSpacePage = new BookSpacePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        filterPage = new FilterPage(driver);
        welcomePage.clickSignInButton();
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        signInPage.signInButtonclick();
        bookSpacePage.filterButtonClick();
    }

    @Test(priority = 1)
    public void locationTest() {
        filterPage.setCity(5);
        String city = filterPage.getCityText();
        Assert.assertEquals("Moscow", city);
        filterPage.setSpace(4);
        String space = filterPage.getSpaceText();
        Assert.assertEquals("Cabinet Lounge", space);
    }

    @Test(priority = 2)
    public void facilitiesAndSwitcherTest() {
        filterPage.setFacilities(0);
        String facilities = filterPage.getFacilitiesText();
        Assert.assertEquals("Conference Phone", facilities);
        filterPage.setSwitcherSpacePass();
    }

    @Test(priority = 3)
    public void setDateTest() {
        filterPage.setMonth("July");
        filterPage.setDay("10");
        filterPage.setYear("2018");
        String date = filterPage.getDateText();
        Assert.assertEquals("Jul 10, 2018", date);
    }

    @Test(priority = 4)
    public void setStartTimeTest() {
        filterPage.setStartHour("9");
        filterPage.setStartMinutes("10");
        filterPage.setStartType("PM");
        String startTime = filterPage.getStartTimeIext();
        Assert.assertEquals("09:10 PM", startTime);
    }

    @Test(priority = 5)
    public void setFinishTimeTest() {
        filterPage.setFinishHour("9");
        filterPage.setFinishMinutes("59");
        filterPage.setFinishype("PM");
        String finishTime = filterPage.getFinishTimeIext();
        Assert.assertEquals("09:59 PM", finishTime);
    }

    @Test(priority = 6)
    public void setNumberOfPeopleTest() {
        filterPage.setNumberOfPeople("40-50");
        String numberOfPeople = filterPage.getNumberOfPeopleIext();
        Assert.assertEquals("40-50", numberOfPeople);
    }

    @Test(priority = 7)
    public void findNearestTest() {
        filterPage.setSwitcherFindNearest();
        filterPage.enterBookingDuration("100");
    }

    @Test(priority = 8)
    public void applyFilterTest() {
        filterPage.applyClick();
        String tab = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting room", tab);
    }

    @Test(priority = 9)
    public void cleanFilterTest() {
        bookSpacePage.filterButtonClick();
        filterPage.cleanButtonClick();
        String text = filterPage.getStatText();
        Assert.assertEquals("Space", text);
    }







}
