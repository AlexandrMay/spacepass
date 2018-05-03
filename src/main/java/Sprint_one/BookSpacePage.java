package Sprint_one;

import Sprint_two.RoomPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Dimension;

public class BookSpacePage {

    private IOSDriver driver;

    public BookSpacePage (IOSDriver driver){
        this.driver = driver;
    }

    public String getTabText() {return driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Meeting Room\"])[1]").getText();}

    public MyProfilePage profileButtonClick() {
        driver.findElementByAccessibilityId("Profile").click();
        return new MyProfilePage(driver);
    }

    public MeetingRoomsOnMap showOnMapClick() {
        driver.findElementByAccessibilityId("Show on map").click();
        return new MeetingRoomsOnMap(driver);
    }

    public FilterPage filterButtonClick() {
        driver.findElementByAccessibilityId("Filter").click();
        return new FilterPage(driver);
    }

    public RoomPage goToRoom(int index) {
        driver.findElementsByClassName("XCUIElementTypeCell").get(index).click();
        return new RoomPage(driver);
    }

    public Boolean roomIsVisible(int index){
        return driver.findElementsByClassName("XCUIElementTypeCell").get(index).isDisplayed();
    }

    public BookSpacePage swipeDown() {


        return this;
    }

    public BookSpacePage swipeUp(int index) {
        IOSElement element = (IOSElement) driver.findElementsByClassName("XCUIElementTypeCell").get(index);


        return this;
    }













}
