package Sprint_two;

import Sprint_one.BookSpacePage;
import io.appium.java_client.ios.IOSDriver;

public class RoomPage {

    private IOSDriver driver;

    public RoomPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByAccessibilityId("Room").getText();}

    public BookSpacePage backButtonClick() {
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return new BookSpacePage(driver);
    }





}
