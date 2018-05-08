package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class SignInPage {

    private IOSDriver driver;

    public SignInPage(IOSDriver driver){
        this.driver = driver;
    }

    public String getHeadingText() {
        return driver.findElementByAccessibilityId("Sign In").getText();
    }

    public String getEmailErrorText() {return driver.findElementByAccessibilityId("Wrong format of email").getText();}

    public String getPasswordErrorText() {return driver.findElementByAccessibilityId("Password must be at least 8 characters").getText();}

    public String getPasswordText() {return driver.findElementsByClassName("XCUIElementTypeTextField").get(1).getText();}



    public SignUpPage signUpClick() {
        driver.findElementByAccessibilityId("Sign Up").click();
        return new SignUpPage(driver);
    }

    public BookSpacePage skipButtonClick() {
        driver.findElementByAccessibilityId("Skip").click();
        return new BookSpacePage(driver);
    }

    public PasswordRecoveryPage forgotYourPasswordButtonClick() {
        driver.findElementByAccessibilityId("Forgot your password?").click();
        return new PasswordRecoveryPage(driver);
    }

    public SignInPage typeCreds(String email, String password) {
        driver.findElementsByClassName("XCUIElementTypeTextField").get(0).sendKeys(email);
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys(password);
        return this;
    }

    public SignInPage eyeButtonclick() {
        driver.findElementByAccessibilityId("icEyeVisibilityOffActive").click();
        return this;
    }

    public BookSpacePage signInButtonclick() {
        driver.findElementByAccessibilityId("SIGN IN").click();
        return new BookSpacePage(driver);
    }

    public SignInPage cleanCreds() {
        driver.findElementsByClassName("XCUIElementTypeTextField").get(0).clear();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").clear();
        return this;
    }






















}
