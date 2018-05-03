package Sprint_one;

import Sprint_two.RoomPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
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
        Assert.assertEquals("Filter", heading);
        filterPage.cancelClick();
    }

    @Test
    public void tapToRoom() {
        RoomPage roomPage = bookSpacePage.goToRoom(0);
        String heading = roomPage.getHeadingText();
        Assert.assertEquals("Room", heading);
        roomPage.backButtonClick();
    }

    @Test
    public void swipeUpDownTest() {

        Assert.assertTrue(bookSpacePage.roomIsVisible(2));
    }

    @Test
    public void swipeLeftRightOnTimelineTest() {

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
