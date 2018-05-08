package Sprint_one;

import Sprint_two.MyOfficePage;
import Sprint_two.MeetingRoomPage;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Dimension;

import java.util.concurrent.TimeUnit;

public class BookSpacePage {

    private IOSDriver driver;

    public BookSpacePage (IOSDriver driver){
        this.driver = driver;
    }

    public String getTabText() {return driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Meeting Room\"])[1]").getText();}

    public String timelineIsSwiped() {return driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"13:00\"])[1]").getText();}

    public MyProfilePage profileButtonClick() {
        driver.findElementByAccessibilityId("Profile").click();
        return new MyProfilePage(driver);
    }

    public MeetingRoomsOnMapPage showOnMapClick() {
        driver.findElementByAccessibilityId("Show on map").click();
        return new MeetingRoomsOnMapPage(driver);
    }

    public FilterPage filterButtonClick() {
        driver.findElementByAccessibilityId("Filter").click();
        return new FilterPage(driver);
    }

    public MeetingRoomPage goToRoom(int index) {
        driver.findElementsByClassName("XCUIElementTypeCell").get(index).click();
        return new MeetingRoomPage(driver);
    }

    public Boolean roomIsVisible(int index){
        return driver.findElementsByClassName("XCUIElementTypeCell").get(index).isDisplayed();
    }

    public BookSpacePage swipeUp() throws InterruptedException {
       driver.swipe(100, 450,500, 100, 750);
       Thread.sleep(1000);
        return this;
    }

    public BookSpacePage swipeLeft() throws InterruptedException {
        driver.swipe(335, 350, 100, 350, 750);
        Thread.sleep(1000);
        return this;
    }

    public MyOfficePage myOfficeClick() {
        driver.findElementByAccessibilityId("My Office").click();
        return new MyOfficePage(driver);
    }















}
