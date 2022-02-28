package qa.configurations.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.configurations.config.Configuration;
import qa.configurations.config.ConfigurationManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class IOSDriverManager implements MobileDriver {

    private AppiumDriver<MobileElement> driver;

    @Override
    public AppiumDriver<MobileElement> createInstance(String udid, String platformVersion) {
        try {
            Configuration configuration = ConfigurationManager.getConfiguration();
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(UDID, udid);
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(PLATFORM_VERSION, platformVersion);
            capabilities.setCapability(DEVICE_NAME, configuration.iosDeviceName());
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(APP, new File(configuration.iosAppPath()).getAbsolutePath());
            capabilities.setCapability(IOSMobileCapabilityType.APP_NAME, configuration.iosAppName());

            driver = new IOSDriver<>(new URL(gridUrl()), capabilities);
        } catch (MalformedURLException e) {
        }

        return driver;
    }
}