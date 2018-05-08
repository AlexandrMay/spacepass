package Sprint_two;

import io.appium.java_client.ios.IOSDriver;

public class PleaseSignInPage {

    private IOSDriver driver;

    public PleaseSignInPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeaderText() {return driver.findElementByAccessibilityId("Please, Sign In to continue").getText();}

    public BookMeetingRoomPage clickCancel() {
        driver.findElementByAccessibilityId("Cancel").click();
        return new BookMeetingRoomPage(driver);
    }



}
