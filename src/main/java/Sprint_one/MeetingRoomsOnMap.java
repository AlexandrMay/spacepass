package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class MeetingRoomsOnMap {

    private IOSDriver driver;

    public MeetingRoomsOnMap (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByClassName("XCUIElementTypeNavigationBar").getText();}

    public BookSpacePage backButtonClick() {
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return new BookSpacePage(driver);
    }



}
