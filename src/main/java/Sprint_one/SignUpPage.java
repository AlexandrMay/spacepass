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

    public String getUseEmailErrorText() {return driver.findElementByAccessibilityId("This email address is already in use").getText();}

    public String getPasswordErrorText() {return driver.findElementByAccessibilityId("Password must be at least 8 characters").getText();}

    public String getEmailtext() {return driver.findElementsByClassName("XCUIElementTypeTextField").get(0).getText();}

    public String getPasswordText() {return driver.findElementsByClassName("XCUIElementTypeTextField").get(1).getText();}





    public BookSpacePage skipButtonClick() {
        driver.findElementByAccessibilityId("Skip").click();
        return new BookSpacePage(driver);
    }

    public SignUpPage typeCreds(String email, String password) {
        driver.findElementsByClassName("XCUIElementTypeTextField").get(0).sendKeys(email);
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys(password);
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
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"I agree with Terms and conditions Terms of Payment Processing, Privacy Policy\"]").click();
        return new TermsPage(driver);
    }

    public BookSpacePage signUpButtonClick() {
        driver.findElementByAccessibilityId("Sign Up").click();
        return new BookSpacePage(driver);
    }

    public SignUpPage cleanCreds() {
        driver.findElementsByClassName("XCUIElementTypeTextField").get(0).clear();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").clear();
        return this;
    }




















}
