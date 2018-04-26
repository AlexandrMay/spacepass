package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class TermsPage {

    private IOSDriver driver;

    public TermsPage (IOSDriver driver){
        this.driver = driver;
    }


    public String getHeadingText() {return driver.findElementByXPath("//XCUIElementTypeOther[@name=Terms and conditions Terms of Payment Processing, Privacy Policy]").getText();}

    public SignUpPage cancelButtonClick() {
        driver.findElementByAccessibilityId("Cancel").click();
        return new SignUpPage(driver);
    }

}
