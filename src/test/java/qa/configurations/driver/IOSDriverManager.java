package qa.configurations.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.configurations.config.Configuration;
import qa.configurations.config.ConfigurationManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class IOSDriverManager {

    private AppiumDriver<MobileElement> driver;

    protected AppiumDriver<MobileElement> createInstance() {
        try {
            Configuration configuration = ConfigurationManager.getConfiguration();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(PLATFORM_VERSION, configuration.iosPlatformVersion());
            capabilities.setCapability(DEVICE_NAME, configuration.iosDeviceName());
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(APP, new File(configuration.iosAppPath()).getAbsolutePath());
            driver = new IOSDriver<>(new URL(configuration.serverUri()), capabilities);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
        }
        return driver;
    }
}