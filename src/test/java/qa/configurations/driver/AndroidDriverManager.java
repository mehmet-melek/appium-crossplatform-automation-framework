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
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidDriverManager {

    private AppiumDriver<MobileElement> driver;


    protected AppiumDriver<MobileElement> createInstance() {
        try {
            Configuration configuration = ConfigurationManager.getConfiguration();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(PLATFORM_VERSION, configuration.androidPlatformVersion());
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capabilities.setCapability(APP, new File(configuration.androidAppPath()).getAbsolutePath());
            capabilities.setCapability(APP_PACKAGE, configuration.androidAppPackage());
            capabilities.setCapability(APP_ACTIVITY, configuration.androidAppActivity());
            driver = new AndroidDriver<>(new URL(configuration.serverUri()), capabilities);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(15, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
        }
        return driver;
    }

}

