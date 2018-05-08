package Sprint_two;

import Sprint_one.BookSpacePage;
import io.appium.java_client.ios.IOSDriver;

public class MyOfficePage {

    private IOSDriver driver;

    public MyOfficePage (IOSDriver driver){
        this.driver = driver;
    }

    public BookSpacePage bookSpaceClick() {
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BookSpace\"]").click();
        return new BookSpacePage(driver);
    }






}
