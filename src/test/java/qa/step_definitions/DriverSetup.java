package qa.step_definitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    private static AppiumDriver<MobileElement> driver;
    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }



    public DriverSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "Pixel_3a");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/resources/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("systemPort","8201");
        driver = new AppiumDriver<>(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
    }
}
