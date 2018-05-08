package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class FilterPage {

    private IOSDriver driver;

    public FilterPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"LOCATION\"]").getText();}

    public BookSpacePage cancelClick() {
        driver.findElementByAccessibilityId("Cancel").click();
        return new BookSpacePage(driver);
    }

    public String getStatText() {return driver.findElementsByClassName("XCUIElementTypeStaticText").get(3).getText();}

    public String getCityText() {return driver.findElementByAccessibilityId("Moscow").getText();}

    public String getSpaceText() {return driver.findElementByAccessibilityId("Cabinet Lounge").getText();}

    public String getFacilitiesText() {return driver.findElementByAccessibilityId("Conference Phone").getText();}

    public String getDateText() {return driver.findElementByAccessibilityId("Jul 10, 2018").getText();}

    public String getStartTimeIext() {return driver.findElementByAccessibilityId("09:10 PM").getText();}

    public String getFinishTimeIext() {return driver.findElementByAccessibilityId("09:59 PM").getText();}

    public String getNumberOfPeopleIext() {return driver.findElementByAccessibilityId("40-50").getText();}

    public BookSpacePage applyClick() {
        driver.findElementByAccessibilityId("Apply").click();
        return new BookSpacePage(driver);
    }

    public FilterPage setCity(int index) {
        driver.findElementByAccessibilityId("City").click();
        driver.findElementsByClassName("XCUIElementTypeCell").get(index).click();
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return this;
    }

    public FilterPage setSpace(int index) {
        driver.findElementByAccessibilityId("Space").click();
        driver.findElementsByClassName("XCUIElementTypeCell").get(index).click();
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return this;
    }

    public FilterPage setFacilities(int index) {
        driver.findElementByAccessibilityId("Facilities").click();
        driver.findElementsByClassName("XCUIElementTypeCell").get(index).click();
        driver.findElementByClassName("XCUIElementTypeButton").click();
        return this;
    }

    public void setSwitcherSpacePass() {
        driver.findElementByXPath("//XCUIElementTypeSwitch[@name=\"Available on SpacePass\"]").click();
    }

    public void setSwitcherFindNearest() {
        driver.findElementByXPath("//XCUIElementTypeSwitch[@name=\"Find nearest\"]").click();
    }

    public FilterPage enterBookingDuration (String duration) {
        driver.findElementByAccessibilityId("Enter booking duration").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys(duration);
        driver.findElementByAccessibilityId("Enter booking duration").click();
        return this;
    }

    public FilterPage setMonth(String month) {
        driver.findElementByAccessibilityId("Day").click();
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys(month);
        return this;
    }
    public FilterPage setDay(String day) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(1).sendKeys(day);
        return this;
    }

    public FilterPage setYear(String year) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(2).sendKeys(year);
        driver.findElementByAccessibilityId("Day").click();
        return this;
    }

    public FilterPage setStartHour(String hour) {
        driver.findElementByAccessibilityId("Start time").click();
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(3).sendKeys(hour);
        return this;
    }

    public FilterPage setStartMinutes (String minutes) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(4).sendKeys(minutes);
        return this;
    }

    public FilterPage setStartType (String type) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(5).sendKeys(type);
        driver.findElementByAccessibilityId("Start time").click();
        return this;
    }

    public FilterPage setFinishHour(String hour) {
        driver.findElementByAccessibilityId("Finish time").click();
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(6).sendKeys(hour);
        return this;
    }

    public FilterPage setFinishMinutes (String minutes) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(7).sendKeys(minutes);
        return this;
    }

    public FilterPage setFinishype (String type) {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(8).sendKeys(type);
        driver.findElementByAccessibilityId("Finish time").click();
        return this;
    }

    public FilterPage setNumberOfPeople (String number) {
        driver.findElementByAccessibilityId("Number of people").click();
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(9).sendKeys(number);
        driver.findElementByAccessibilityId("Number of people").click();
        return this;
    }

    public FilterPage cleanButtonClick() {
        driver.findElementByAccessibilityId("Clean").click();
        return this;
    }





}
