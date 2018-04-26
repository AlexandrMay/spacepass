package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class BookSpacePage {

    private IOSDriver driver;

    public BookSpacePage (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByClassName("XCUIElementTypeNavigationBar").getText();}



}
