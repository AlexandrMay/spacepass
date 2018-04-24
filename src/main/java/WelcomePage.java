import io.appium.java_client.ios.IOSDriver;


public class WelcomePage {

    private IOSDriver driver;

    public WelcomePage(IOSDriver driver){
        this.driver = driver;
    }

    public SignUpPage clickStartButton() {
        driver.findElementByAccessibilityId("START").click();
    return new SignUpPage(driver);
    }

    public SignInPage clickSignInButton() {
        driver.findElementByAccessibilityId("Sign In").click();
        return new SignInPage(driver);
    }

}
