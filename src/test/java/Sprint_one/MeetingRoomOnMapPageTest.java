package Sprint_one;

import Sprint_two.MeetingRoomPage;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MeetingRoomOnMapPageTest extends Caps {

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private BookSpacePage bookSpacePage;
    private MeetingRoomsOnMapPage meetingRoomsOnMapPage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        bookSpacePage = new BookSpacePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        meetingRoomsOnMapPage = new MeetingRoomsOnMapPage(driver);
        welcomePage.clickSignInButton();
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        signInPage.signInButtonclick();
        bookSpacePage.showOnMapClick();
    }

    @Test(priority = 1)
    public void clickToRoomTest() {
        meetingRoomsOnMapPage.backButtonClick();
        bookSpacePage.showOnMapClick();
        MeetingRoomPage roomPage = meetingRoomsOnMapPage.clickToRoom(0);
        String heading = roomPage.getStartText();
        Assert.assertEquals("Start", heading);
        roomPage.backButtonClick();
    }


   @Test(priority = 2)
    public void swipeToLeftTest() throws InterruptedException {
        meetingRoomsOnMapPage.backButtonClick();
        bookSpacePage.showOnMapClick();
        meetingRoomsOnMapPage.swipeToLeft();
        Assert.assertTrue(meetingRoomsOnMapPage.secondRoomIsVisible());
    }

}
