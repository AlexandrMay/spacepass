package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.net.MalformedURLException;

public class WelcomeTest extends Caps{

    private IOSDriver driver;
    private WelcomePage welcomePage;

    @BeforeMethod
    public void setUP() throws MalformedURLException {
        driver = Caps.capabilities();
        welcomePage = new WelcomePage(driver);
    }

    @Test
    public void startButtonTest(){
        SignUpPage signUpPage = welcomePage.clickStartButton();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign Up", heading);
    }

    @Test
    public void signInButtonTest() {

        SignInPage signInPage = welcomePage.clickSignInButton();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign In", heading);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



