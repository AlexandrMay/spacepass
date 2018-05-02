package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class FilterPage {

    private IOSDriver driver;

    public FilterPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {return driver.findElementByAccessibilityId("").getText();}









}
