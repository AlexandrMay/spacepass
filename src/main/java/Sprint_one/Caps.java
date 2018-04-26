package Sprint_one;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Caps {

    static IOSDriver driver;

    public static IOSDriver capabilities() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        cap.setCapability(MobileCapabilityType.APP, "/Users/woxapp/Library/Developer/Xcode/DerivedData/SpaceIn-dumwlseggfmusmbcarspdfdbnvpo/Build/Products/Debug-iphonesimulator/SpaceIn.app");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

}
