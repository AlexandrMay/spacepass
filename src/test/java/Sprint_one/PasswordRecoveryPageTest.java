package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class PasswordRecoveryPageTest extends Caps {

    private IOSDriver driver;
    private SignInPage signInPage;
    private WelcomePage welcomePage;
    private PasswordRecoveryPage passwordRecoveryPage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        welcomePage.clickSignInButton();
        signInPage.forgotYourPasswordButtonClick();
    }

    @Test(priority = 1)
    public void wrongEmailTest() {
        passwordRecoveryPage.typeEmail("test");
        passwordRecoveryPage.getPassButtonClick();
        String error = passwordRecoveryPage.getEmailErrorText();
        Assert.assertEquals("Wrong format of email", error);
        passwordRecoveryPage.cleanEmailField();
    }

    @Test(priority = 2)
    public void correctEmailTest() {
        passwordRecoveryPage.typeEmail("maysalexandr@gmail.com");
        passwordRecoveryPage.getPassButtonClick();
        passwordRecoveryPage.getPassButtonClick();
        passwordRecoveryPage.clickOkOnAlert();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign In", heading);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
