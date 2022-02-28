package qa.configurations.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.configurations.config.Configuration;
import qa.configurations.config.ConfigurationManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidDriverManager implements MobileDriver {

    private AppiumDriver<MobileElement> driver;


    @Override
    public AppiumDriver<MobileElement> createInstance(String udid, String platformVersion) {
        try {
            Configuration configuration = ConfigurationManager.getConfiguration();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(PLATFORM_VERSION, platformVersion);
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capabilities.setCapability(DEVICE_NAME, configuration.androidDeviceName());
            capabilities.setCapability(APP, new File(configuration.androidAppPath()).getAbsolutePath());
            capabilities.setCapability(APP_PACKAGE, configuration.androidAppPackage());
            capabilities.setCapability(APP_ACTIVITY, configuration.androidAppActivity());
            driver = new AndroidDriver<>(new URL(gridUrl()), capabilities);
        } catch (MalformedURLException e) {
        }

        return driver;
    }

}

