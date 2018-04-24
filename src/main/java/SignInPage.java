import io.appium.java_client.ios.IOSDriver;

public class SignInPage {

    private IOSDriver driver;

    public SignInPage(IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {
        return driver.findElementByAccessibilityId("header").getText();
    }





}
