package qa.configurations.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverFactory {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void createDriver() {
        String platform = System.getProperty("platform").toUpperCase();
        switch (platform) {
            case "IOS":
                driver = new IOSDriverManager().createInstance();
                break;

            case "ANDROID":
                driver = new AndroidDriverManager().createInstance();
                break;

            default:
                throw new IllegalStateException
                        ("Platform not supported! Check if you set ios or android on the parameter.");
        }
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void resetApp() {
        if (driver != null) {
            driver.resetApp();
        }
    }
}