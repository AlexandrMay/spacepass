package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BookSpacePageTest extends Caps{

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private BookSpacePage bookSpacePage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = Caps.capabilities();
        bookSpacePage = new BookSpacePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        welcomePage.clickSignInButton();
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        signInPage.signInButtonclick();
    }

    @Test
    public void meetingRoomsOnMapButtonClick() {
        MeetingRoomsOnMap meetingRoomsOnMap = bookSpacePage.showOnMapClick();
        String heading = meetingRoomsOnMap.getHeadingText();
        Assert.assertEquals("Meeting rooms on map", heading);
        meetingRoomsOnMap.backButtonClick();

    }

    @Test
    public void filterButtonTest() {
        FilterPage filterPage = bookSpacePage.filterButtonClick();
        String heading = filterPage.getHeadingText();

    }






    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
