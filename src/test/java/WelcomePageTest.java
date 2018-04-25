import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class WelcomePageTest extends Caps {

    private IOSDriver driver;
    private WelcomePage welcomePage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        welcomePage = new WelcomePage(driver);
    }

   @Test
    public void startButtonTest(){
        SignUpPage signUpPage = welcomePage.clickStartButton();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign Up", heading);
        driver.navigate().back();
    }

    @Test
    public void signInButtonTest() {

        SignInPage signInPage = welcomePage.clickSignInButton();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign In", heading);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
