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
    private SignUpPage signUpPage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        signUpPage = new SignUpPage(driver);
        welcomePage.clickSignInButton();
    }

    @Test(priority = 1)
    public void skipButtonTest() {
        BookSpacePage bookSpacePage = signInPage.skipButtonClick();
        String heading = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", heading);
        MyProfilePage myProfilePage = bookSpacePage.profileButtonClick();
        myProfilePage.logOutClick();
        signUpPage.iHaveAnAccButtonClick();

    }


    @Test(priority = 6)
    public void forgotYourPasswordButtonTest() {
        PasswordRecoveryPage passwordRecoveryPage = signInPage.forgotYourPasswordButtonClick();
        String heading = passwordRecoveryPage.getPasswordRecoveryPageHeading();
        Assert.assertEquals("Password recovery",heading);
        passwordRecoveryPage.backButtonClick();
    }

    @Test(priority = 3)
    public void correctCreds(){
        signInPage.typeCreds("maysalexandr@gmail.com", "12345678");
        BookSpacePage bookSpacePage = signInPage.signInButtonclick();
        String tabText = bookSpacePage.getTabText();
        Assert.assertEquals("Meeting Room", tabText);
        MyProfilePage myProfilePage = bookSpacePage.profileButtonClick();
        myProfilePage.logOutClick();
        signUpPage.iHaveAnAccButtonClick();
    }

    @Test(priority = 2)
    public void incorrectCreds(){
        signInPage.typeCreds("test", "test");
        signInPage.signInButtonclick();
        String emailError = signInPage.getEmailErrorText();
        String passwordError = signInPage.getPasswordErrorText();
        Assert.assertEquals("Wrong format of email", emailError);
        Assert.assertEquals("Password must be at least 8 characters", passwordError);
        signInPage.cleanCreds();
    }

    @Test(priority = 4)
    public void eyeButtonTest() {
        signInPage.typeCreds("test1@test.com", "12345678");
        signInPage.eyeButtonclick();
        String password = signInPage.getPasswordText();
        Assert.assertEquals("12345678", password);
        signInPage.eyeButtonclick();
        signInPage.cleanCreds();
        driver.hideKeyboard();
    }

    @Test(priority = 5)
    public void signUpButtonTest() {
        SignUpPage signUpPage = signInPage.signUpClick();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign Up", heading);
        signUpPage.iHaveAnAccButtonClick();
    }

}
