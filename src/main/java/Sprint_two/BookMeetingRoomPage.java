package Sprint_two;

import Sprint_one.BookSpacePage;
import io.appium.java_client.ios.IOSDriver;

public class BookMeetingRoomPage {

    private IOSDriver driver;

    public BookMeetingRoomPage (IOSDriver driver){
        this.driver = driver;
    }


    public String getButtonText() {return driver.findElementByAccessibilityId("PAY FOR BOOKING").getText();}

    public MeetingRoomPage cancelClick() {
        driver.findElementByAccessibilityId("Cancel").click();
        return new MeetingRoomPage(driver);
    }

    public BookMeetingRoomPage checkBoxClick() {
        driver.findElementByAccessibilityId("checkboxOff").click();
        return this;
    }

    public PleaseSignInPage payForBookingClick() {
        driver.findElementByAccessibilityId("PAY FOR BOOKING").click();
        return new PleaseSignInPage(driver);
    }

    public BookSpacePage fakePaymentClick() {
        driver.findElementByAccessibilityId("Fake Payment").click();
        driver.findElementByAccessibilityId("OK").click();
        return new BookSpacePage(driver);
    }











}
