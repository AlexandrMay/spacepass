package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class MyProfilePage {

    private IOSDriver driver;

    public MyProfilePage(IOSDriver driver){
        this.driver = driver;
    }

    public SignUpPage logOutClick() {
        driver.findElementByAccessibilityId("Log Out").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Log Out\"]").click();
        return new SignUpPage(driver);
    }



}
