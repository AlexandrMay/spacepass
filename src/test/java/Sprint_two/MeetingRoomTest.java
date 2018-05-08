package Sprint_two;

import Sprint_one.BookSpacePage;
import Sprint_one.Caps;
import Sprint_one.SignInPage;
import Sprint_one.WelcomePage;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MeetingRoomTest extends Caps {

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private BookSpacePage bookSpacePage;
    private MeetingRoomPage meetingRoomPage;


    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        bookSpacePage = new BookSpacePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        bookSpacePage = new BookSpacePage(driver);
        meetingRoomPage = new MeetingRoomPage(driver);
        welcomePage.clickSignInButton();
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        signInPage.signInButtonclick();
        bookSpacePage.goToRoom(0);
    }

    @Test(priority = 1)
    public void callTest() {
        meetingRoomPage.callMaking();
        String button = meetingRoomPage.getCallButtonText();
        Assert.assertEquals("Вызов", button);
        meetingRoomPage.callCancel();
    }

    @Test(priority = 2)
    public void setDateTest() {
        meetingRoomPage.setMonth("July");
        meetingRoomPage.setDay("10");
        meetingRoomPage.setYear("2018");
        String date = meetingRoomPage.getDateText();
        Assert.assertEquals("Jul 10, 2018", date);
    }

    @Test(priority = 3)
    public void timeActionsTest() {
        meetingRoomPage.plusClick();
        meetingRoomPage.plusClick();
        meetingRoomPage.plusClick();
        meetingRoomPage.minusClick();
        meetingRoomPage.minusClick();
        String bookedTime = meetingRoomPage.getBookedTime();
        Assert.assertEquals("1 hour 30 minutes", bookedTime);
    }

   /* @Test
    public void moveTimeltineTest() {

    }*/

    @Test(priority = 4)
    public void confirmReservationTest() {
        BookMeetingRoomPage bookMeetingRoomPage = meetingRoomPage.confirmClick();
        String heading = bookMeetingRoomPage.getButtonText();
        Assert.assertEquals("PAY FOR BOOKING", heading);
        bookMeetingRoomPage.cancelClick();
    }










}
