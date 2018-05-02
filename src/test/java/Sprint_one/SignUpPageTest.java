package Sprint_one;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

    @Test //+
    public void skipButtonTest(){
        BookSpacePage bookSpacePage = signUpPage.skipButtonClick();
        String heading = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", heading);
        MyProfilePage myProfilePage = bookSpacePage.profileButtonClick();
        myProfilePage.logOutClick();

    }

    /*
    @Test    Issue #8
    public void termsButtonTest() {
        TermsPage termsPage = signUpPage.termsButtonClick();
        String heading = termsPage.getHeadingText();
        Assert.assertEquals("Terms and conditions Terms of Payment Processing, Privacy Policy", heading);
        termsPage.cancelButtonClick();
    } */

    @Test //+
    public void iHaveAnAccTest() {
        SignInPage signInPage = signUpPage.iHaveAnAccButtonClick();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign In", heading);
        signInPage.signUpClick();
    }

  /*      Issue #6
    @Test
    public void emptyFieldsTest() {
        signUpPage.signUpButtonClick();
        Boolean emailError = signUpPage.emailErrorTextIsVisible();
        Boolean passError = signUpPage.passwordErrorTextIsVisible();
        Assert.assertFalse(emailError);
        Assert.assertFalse(passError);
    }
    */

    @Test //+
    public void eyeButtonTest() {
        signUpPage.typeCreds("test1@test.com", "12345678");
        signUpPage.eyeButtonclick();
        String password = signUpPage.getPasswordText();
        Assert.assertEquals("12345678", password);
        signUpPage.cleanCreds();
    }

    @Test //+
    public void emailIsInUseTest() {
        signUpPage.typeCreds("test@test.com", "12345678");
        signUpPage.signUpButtonClick();
        String error = signUpPage.getUseEmailErrorText();
        Assert.assertEquals("This email address is already in use", error);
        signUpPage.eyeButtonclick();
        signUpPage.cleanCreds();
    }

    @Test
    public void checkboxIsUncheckedTest() {
        signUpPage.typeCreds("test1@test.com", "12345678");
        String heading = signUpPage.getHeadingText();
        signUpPage.signUpButtonClick();
        Assert.assertEquals("Sign Up", heading);
        signUpPage.eyeButtonclick();
        signUpPage.cleanCreds();
    }

    @Test
    public void validCredsTest() {
        signUpPage.typeCreds("test1@test.com", "123456789");
        signUpPage.checkBoxclick();
        BookSpacePage bookSpacePage = signUpPage.signUpButtonClick();
        String heading = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", heading);
        MyProfilePage myProfilePage = bookSpacePage.profileButtonClick();
        myProfilePage.logOutClick();
    }

    @Test
    public void invalidCreds() {
        signUpPage.typeCreds("test", "test");
        String emailError = signUpPage.getEmailErrorText();
        String passwordError = signUpPage.getPasswordErrorText();
        Assert.assertEquals("Wrong format of email", emailError);
        Assert.assertEquals("Password must be at least 8 characters", passwordError);
        signUpPage.eyeButtonclick();
        signUpPage.cleanCreds();
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
