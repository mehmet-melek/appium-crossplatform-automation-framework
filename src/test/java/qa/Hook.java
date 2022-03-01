package qa;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import qa.configurations.driver.DriverFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hook {
    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(System.getProperty("screenshot.rel.path") + "/Screenshot.png"));
            byte[] data = Files.readAllBytes(Path.of(System.getProperty("screenshot.rel.path") + "/Screenshot.png"));
            scenario.attach(data, "image/png", "My screenshot");
        }
        DriverFactory.getDriver().closeApp();
        DriverFactory.getDriver().launchApp();
    }

    @AfterAll
    public static void tearDown() {
        DriverFactory.killDriver();
    }


}
