package Sprint_two;

import Sprint_one.*;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BookMeetingRoomTest extends Caps {

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private BookSpacePage bookSpacePage;
    private MeetingRoomPage meetingRoomPage;
    private BookMeetingRoomPage bookMeetingRoomPage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        bookSpacePage = new BookSpacePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        meetingRoomPage = new MeetingRoomPage(driver);
        bookMeetingRoomPage = new BookMeetingRoomPage(driver);

    }

    @Test(priority = 1)
    public void checkBoxIsUncheckedTest() {
        welcomePage.clickSignInButton();
        signInPage.skipButtonClick();
        bookSpacePage.goToRoom(0);
        meetingRoomPage.confirmClick();
        bookMeetingRoomPage.payForBookingClick();
        String button = bookMeetingRoomPage.getButtonText();
        Assert.assertEquals("PAY FOR BOOKING", button);
    }

    @Test(priority = 2)
    public void checkBoxIsCheckedTest() {
        welcomePage.clickSignInButton();
        signInPage.skipButtonClick();
        bookSpacePage.goToRoom(0);
        meetingRoomPage.confirmClick();
        bookMeetingRoomPage.checkBoxClick();
        PleaseSignInPage pleaseSignInPage = bookMeetingRoomPage.payForBookingClick();
        String header = pleaseSignInPage.getHeaderText();
        Assert.assertEquals("Please, Sign In to continue", header);
        pleaseSignInPage.clickCancel();
    }

    @Test(priority = 3)
    public void bookingTest() {
        welcomePage.clickSignInButton();
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        signInPage.signInButtonclick();
        bookSpacePage.goToRoom(0);
        meetingRoomPage.confirmClick();
        bookMeetingRoomPage.checkBoxClick();
        bookMeetingRoomPage.payForBookingClick();
        bookMeetingRoomPage.fakePaymentClick();
        String tab = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", tab);
    }
}
