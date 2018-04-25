import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignUpPageTest extends Caps {

    private IOSDriver driver;
    private SignUpPage signUpPage;

    @BeforeClass
    public void setUP() throws MalformedURLException {
        driver = capabilities();
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void skipButtonTest(){
        BookSpacePage bookSpacePage = signUpPage.skipButtonClick();
        String heading = bookSpacePage.getHeadingText();
        Assert.assertEquals("BookSpace", heading);
        driver.navigate().back();
    }








}
