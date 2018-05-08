package Sprint_one;

import Sprint_two.MeetingRoomPage;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;

import java.util.concurrent.TimeUnit;

public class MeetingRoomsOnMapPage {

    private IOSDriver driver;

    public MeetingRoomsOnMapPage(IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Meeting rooms on map\"]").getText();}

    public Boolean secondRoomIsVisible() {return driver.findElementsByClassName("XCUIElementTypeCell").get(1).isDisplayed();}

    public BookSpacePage backButtonClick() {
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return new BookSpacePage(driver);
    }

    public MeetingRoomPage clickToRoom(int index) {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.findElementsByClassName("XCUIElementTypeCell").get(index).click();
        return new MeetingRoomPage(driver);
    }

    public MeetingRoomsOnMapPage swipeToLeft() throws InterruptedException {
        driver.swipe(365, 580, 10, 580, 100);
        Thread.sleep(1000);
        return this;
    }

}
