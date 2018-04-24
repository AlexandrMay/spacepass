import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.PageFactory;
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
        welcomePage = PageFactory.initElements(driver, WelcomePage.class);
    }

   @Test
    public void startButtonTest(){
        SignUpPage signUpPage = welcomePage.clickStartButton();
    }

    @Test
    public void signUpButtonTest() {
        SignInPage signInPage = welcomePage.clickSignInButton();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
