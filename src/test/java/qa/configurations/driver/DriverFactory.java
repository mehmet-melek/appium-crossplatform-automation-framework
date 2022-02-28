package qa.configurations.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;

public class DriverFactory {

    public AppiumDriver<MobileElement> createInstance(String platform, String udid, String platformVersion) {
        AppiumDriver<MobileElement> driver;
        Platform mobilePlatform = Platform.valueOf(platform.toUpperCase());

        switch (mobilePlatform) {
            case IOS:
                driver = new IOSDriverManager().createInstance(udid, platformVersion);
                break;

            case ANDROID:
                driver = new AndroidDriverManager().createInstance(udid, platformVersion);
                break;

            default:
                throw new IllegalStateException(
                        "Platform not supported! Check if you set ios or android on the parameter.");
        }
        return driver;
    }
}