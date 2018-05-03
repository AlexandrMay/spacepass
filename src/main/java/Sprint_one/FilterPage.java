package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class FilterPage {

    private IOSDriver driver;

    public FilterPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByClassName("XCUIElementTypeNavigationBar").getText();}

    public BookSpacePage cancelClick() {
        driver.findElementByAccessibilityId("Cancel").click();
        return new BookSpacePage(driver);
    }

    public BookSpacePage applyClick() {
        driver.findElementByAccessibilityId("Apply").click();
        return new BookSpacePage(driver);
    }















}
