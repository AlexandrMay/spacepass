package Sprint_two;

import Sprint_one.BookSpacePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Dimension;

public class MeetingRoomPage {

    private IOSDriver driver;

    public MeetingRoomPage(IOSDriver driver){
        this.driver = driver;
    }

    public String getStartText() {return driver.findElementByAccessibilityId("Start").getText();}

    public String getCallButtonText() {return driver.findElementByAccessibilityId("Вызов").getText();}

    public String getDateText() {return driver.findElementByAccessibilityId("Jul 10, 2018").getText();}

    public String getBookedTime() {return driver.findElementByAccessibilityId("1 hour 30 minutes").getText();}

    public BookSpacePage backButtonClick() {
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return new BookSpacePage(driver);
    }

    public void callMaking() {
        driver.findElementByAccessibilityId("Undefined phone").click();
    }

    public void callCancel() {
        driver.findElementByAccessibilityId("Отменить").click();
    }

    public MeetingRoomPage setMonth(String month) {
        driver.findElementByAccessibilityId("Reservation day").click();
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys(month);
        return new MeetingRoomPage(driver);
    }

    public MeetingRoomPage setDay(String day) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(1).sendKeys(day);
        return new MeetingRoomPage(driver);
    }

    public MeetingRoomPage setYear (String year) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(2).sendKeys(year);
        driver.findElementByAccessibilityId("Reservation day").click();
        return new MeetingRoomPage(driver);
    }

    public MeetingRoomPage plusClick() {
        driver.findElementByAccessibilityId("plus").click();
        return this;
    }

    public MeetingRoomPage minusClick() {
        driver.findElementByAccessibilityId("minus").click();
        return this;
    }

    public MeetingRoomPage moveLeftDot() {
        IOSElement dot = (IOSElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"SpacePass\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
        IOSElement markTen = (IOSElement) driver.findElementByAccessibilityId("10:00");
        TouchAction action = new TouchAction(driver);
        action.press(dot).perform();
        action = new TouchAction(driver);
        action.press(dot).moveTo(markTen).release().perform();
        return this;
    }

    public BookMeetingRoomPage confirmClick() {
        driver.findElementByAccessibilityId("CONFIRM RESERVATION").click();
        return new BookMeetingRoomPage(driver);
    }
















}
