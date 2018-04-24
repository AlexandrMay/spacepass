import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;


public class WelcomePage {

    private IOSDriver driver;

    public WelcomePage(IOSDriver driver){
        this.driver = driver;
    }

    @iOSFindBy(accessibility = "START")
    private MobileElement startButton;

    @iOSFindBy(accessibility = "Sign In")
    private MobileElement signInButton;


    public SignUpPage clickStartButton() {
        startButton.click();
    return new SignUpPage(driver);
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(driver);
    }

}
