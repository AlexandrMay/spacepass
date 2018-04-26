package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignUpPageTest extends Caps {

    private IOSDriver driver;
    private SignUpPage signUpPage;
    private WelcomePage welcomePage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = Caps.capabilities();
        signUpPage = new SignUpPage(driver);
        welcomePage = new WelcomePage(driver);
        welcomePage.clickStartButton();
    }

    @Test
    public void skipButtonTest(){
        BookSpacePage bookSpacePage = signUpPage.skipButtonClick();
        String heading = bookSpacePage.getHeadingText();
        Assert.assertEquals("BookSpace", heading);
        driver.navigate().back();
    }

    @Test
    public void termsButtonTest() {
        TermsPage termsPage = signUpPage.termsButtonClick();
        String heading = termsPage.getHeadingText();
        Assert.assertEquals("Terms and conditions Terms of Payment Processing, Privacy Policy", heading);
        termsPage.cancelButtonClick();
    }

    @Test
    public void iHaveAnAccTest() {
        SignInPage signInPage = signUpPage.iHaveAnAccButtonClick();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign In", heading);
        driver.navigate().back();
    }

    @Test
    public void emptyFieldsTest() {
        signUpPage.signUpButtonClick();
        Boolean emailError = signUpPage.emailErrorTextIsVisible();
        Boolean passError = signUpPage.passwordErrorTextIsVisible();
        Assert.assertFalse(emailError);
        Assert.assertFalse(passError);
    }

    @Test
    public void eyeButtonTest() {
        signUpPage.typeCreds(null, "12345678");
        signUpPage.eyeButtonclick();
        String password = signUpPage.getPasswordText();
        Assert.assertEquals("12345678", password);
    }

    @Test
    public void emailIsInUseTest() {
        signUpPage.typeCreds("test@test.com", null);
        signUpPage.signUpButtonClick();
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("This email address is already in use", error);
    }

    @Test
    public void checkboxIsUncheckedTest() {
        signUpPage.typeCreds("test1@test.com", "123456789");
        String heading = signUpPage.getHeadingText();
        signUpPage.signUpButtonClick();
        Assert.assertEquals("Sign Up", heading);
    }














}
