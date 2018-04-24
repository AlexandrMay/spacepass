import io.appium.java_client.ios.IOSDriver;

public class SignUpPage {

    private IOSDriver driver;

    public SignUpPage(IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {
        return driver.findElementByAccessibilityId("header").getText();
    }



}
