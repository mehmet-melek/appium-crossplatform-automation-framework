package qa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import qa.step_definitions.DriverSetup;

import java.net.MalformedURLException;


@RunWith(Cucumber.class)
@CucumberOptions(publish = false,
        features = "src/test/resources/features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CucumberTestRunner {

    @BeforeClass()
    public static void doSomething() throws MalformedURLException {
        new DriverSetup();
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Execution Report: " + System.getProperty("report.url"));
        DriverSetup.getDriver().closeApp();
    }


}
