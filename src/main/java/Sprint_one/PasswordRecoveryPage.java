package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class PasswordRecoveryPage {

    private IOSDriver driver;

    public PasswordRecoveryPage (IOSDriver driver){
        this.driver = driver;
    }

    public String getPasswordRecoveryPageHeading() {return driver.findElementByAccessibilityId("Password recovery").getText();}

    public String getEmailErrorText() {return driver.findElementByAccessibilityId("Wrong format of email").getText();}

    public SignInPage backButtonClick() {
        driver.findElementByAccessibilityId("iconBack").click();
        return new SignInPage(driver);
    }

    public SignInPage getPassButtonClick() {
        driver.findElementByAccessibilityId("GET PASSWORD").click();
        return new SignInPage(driver);
    }

    public SignInPage typeEmail(String email) {
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys(email);
        return new SignInPage(driver);
    }

    public PasswordRecoveryPage cleanEmailField() {
        driver.findElementByClassName("XCUIElementTypeTextField").clear();
        return this;
    }

    public SignInPage clickOkOnAlert() {
        driver.findElementByAccessibilityId("OK").click();
        return new SignInPage(driver);
    }







}
