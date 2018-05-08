package Sprint_one;

import Sprint_two.MyOfficePage;
import Sprint_two.MeetingRoomPage;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BookSpacePageTest extends Caps{

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private BookSpacePage bookSpacePage;


    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();

        bookSpacePage = new BookSpacePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        welcomePage.clickSignInButton();
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        signInPage.signInButtonclick();
    }

    @Test(priority = 1)
    public void meetingRoomsOnMapButtonClick() {
        MeetingRoomsOnMapPage meetingRoomsOnMap = bookSpacePage.showOnMapClick();
        String heading = meetingRoomsOnMap.getHeadingText();
        Assert.assertEquals("Meeting rooms on map", heading);
        meetingRoomsOnMap.backButtonClick();

    }

    @Test(priority = 2)
    public void filterButtonTest() {
        FilterPage filterPage = bookSpacePage.filterButtonClick();
        String heading = filterPage.getHeadingText();
        Assert.assertEquals("LOCATION", heading);
        filterPage.cancelClick();
    }

    @Test(priority = 3)
    public void tapToRoom() {
        MeetingRoomPage roomPage = bookSpacePage.goToRoom(0);
        String heading = roomPage.getStartText();
        Assert.assertEquals("Start", heading);
        roomPage.backButtonClick();
    }

    @Test(priority = 5)
    public void swipeUpTest() throws InterruptedException {
        bookSpacePage.swipeUp();
        Assert.assertTrue(bookSpacePage.roomIsVisible(2));
    }

    @Test(priority = 4)
    public void swipeTimelineTest() throws InterruptedException {
        bookSpacePage.swipeLeft();
        String text = bookSpacePage.timelineIsSwiped();
        Assert.assertEquals("13:00", text);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
