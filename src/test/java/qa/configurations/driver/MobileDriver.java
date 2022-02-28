package qa.configurations.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import qa.configurations.config.Configuration;
import qa.configurations.config.ConfigurationManager;

public interface MobileDriver {

    AppiumDriver<MobileElement> createInstance(String udid, String platformVersion);

    default String gridUrl() {
        Configuration configuration = ConfigurationManager.getConfiguration();
        return String.format("http://%s:%s/wd/hub", configuration.serverIp(), configuration.serverPort());
    }
}
