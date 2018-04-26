package Sprint_one;

import io.appium.java_client.ios.IOSDriver;

public class SignUpPage {

    private IOSDriver driver;

    public SignUpPage(IOSDriver driver){
        this.driver = driver;
    }



    public String getHeadingText() {
        return driver.findElementByAccessibilityId("Sign Up").getText();
    }

    public String getEmailErrorText() {return driver.findElementByAccessibilityId("Wrong format of email").getText();}

    public String getPasswordErrorText() {return driver.findElementByAccessibilityId("Password must be at least 8 characters").getText();}

    public String getPasswordText() {return driver.findElementsByClassName("XCUIElementTypeTextField").get(1).getText();}

    public Boolean emailErrorTextIsVisible() {return driver.findElementByAccessibilityId("Wrong format of email").isDisplayed();}

    public Boolean passwordErrorTextIsVisible() {return driver.findElementByAccessibilityId("Password must be at least 8 characters").isDisplayed();}



    public BookSpacePage skipButtonClick() {
        driver.findElementByAccessibilityId("Skip").click();
        return new BookSpacePage(driver);
    }

    public SignUpPage typeCreds(String email, String password) {
        driver.findElementsByClassName("XCUIElementTypeTextField").get(0).sendKeys(email);
        driver.findElementsByClassName("XCUIElementTypeTextField").get(1).sendKeys(password);
        return this;
    }

    public SignUpPage checkBoxclick() {
        driver.findElementByAccessibilityId("checkboxOff").click();
        return this;
    }

    public SignUpPage eyeButtonclick() {
        driver.findElementByAccessibilityId("icEyeVisibilityOffActive").click();
        return this;
    }

    public SignInPage iHaveAnAccButtonClick(){
        driver.findElementByAccessibilityId("I have an acount").click();
        return new SignInPage(driver);
    }

    public TermsPage termsButtonClick() {
        driver.findElementByAccessibilityId("I agree with Terms and conditions Terms of Payment Processing, Privacy Policy").click();
        return new TermsPage(driver);
    }

    public BookSpacePage signUpButtonClick() {
        driver.findElementByAccessibilityId("Sign Up").click();
        return new BookSpacePage(driver);
    }




















}
