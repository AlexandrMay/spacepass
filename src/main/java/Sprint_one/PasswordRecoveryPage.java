package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class PasswordRecoveryPage {

    private IOSDriver driver;

    public PasswordRecoveryPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getPasswordRecoveryPageHeading() {return driver.findElementByAccessibilityId("Password recovery").getText();}

    public SignInPage backButtonClick() {
        driver.findElementByAccessibilityId("iconBack").click();
        return new SignInPage(driver);
    }




}
