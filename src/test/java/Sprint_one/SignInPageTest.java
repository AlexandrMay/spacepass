package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignInPageTest extends Caps{

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = Caps.capabilities();
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        welcomePage.clickSignInButton();
    }

    @Test //+
    public void skipButtonTest() {

        BookSpacePage bookSpacePage = signInPage.skipButtonClick();
        String heading = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", heading);
        MyProfilePage myProfilePage = bookSpacePage.profileButtonClick();
        myProfilePage.logOutClick();

    }


    @Test  //+
    public void forgotYourPasswordButtonTest() {
        PasswordRecoveryPage passwordRecoveryPage = signInPage.forgotYourPasswordButtonClick();
        String heading = passwordRecoveryPage.getPasswordRecoveryPageHeading();
        Assert.assertEquals("Password recovery",heading);
        passwordRecoveryPage.backButtonClick();
    }

    /*    Issue #60
    @Test
    public void wrongEmailTest() {
        signInPage.typeCreds("test@test.com", "12345678");
        signInPage.signInButtonclick();
        String error = signInPage.getEmailErrorText();
        Assert.assertEquals("Email not registered", error);
        signInPage.eyeButtonclick();
        signInPage.cleanCreds();
    }

        Issue #13
    @Test
    public void wrongPasswordTest() {
        signInPage.typeCreds("test1@test.com", "1");
        signInPage.signInButtonclick();
        String error = signInPage.getPasswordErrorText();
        Assert.assertEquals("Password must be at least 8 characters", error);
        signInPage.eyeButtonclick();
        signInPage.cleanCreds();

    } */

    @Test //+
    public void correctCreds(){
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        BookSpacePage bookSpacePage = signInPage.signInButtonclick();
        String tabText = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", tabText);
        MyProfilePage myProfilePage = bookSpacePage.profileButtonClick();
        myProfilePage.logOutClick();
    }

    @Test
    public void incorrectCreds(){
        signInPage.typeCreds("test", "test");
        signInPage.signInButtonclick();
        String emailError = signInPage.getEmailErrorText();
        String passwordError = signInPage.getPasswordErrorText();
        Assert.assertEquals("Wrong format of email", emailError);
        Assert.assertEquals("Password must be at least 8 characters", passwordError);
        signInPage.eyeButtonclick();
        signInPage.cleanCreds();
    }

    @Test //++
    public void eyeButtonTest() {
        signInPage.typeCreds("test1@test.com", "12345678");
        signInPage.eyeButtonclick();
        String password = signInPage.getPasswordText();
        Assert.assertEquals("12345678", password);
        signInPage.cleanCreds();
    }

    @Test //+
    public void signUpButtonTest() {

        SignUpPage signUpPage = signInPage.signUpClick();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign Up", heading);
        signUpPage.iHaveAnAccButtonClick();
    }













}
