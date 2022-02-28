package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait driverWait;

    public PageBase(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
        driverWait = new WebDriverWait(driver, 20);
    }

    public void waitUntilVisible(MobileElement mobileElement) {
        driverWait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public void click(MobileElement mobileElement) {
        waitUntilVisible(mobileElement);
        mobileElement.click();
    }

    public void sendKeys(MobileElement mobileElement, String text) {
        waitUntilVisible(mobileElement);
        mobileElement.clear();
        mobileElement.sendKeys(text);
    }

    public String getElementText(MobileElement mobileElement) {
        return mobileElement.getText();
    }

    public MobileElement getElementFromElementList(List<MobileElement> mobileElementList, int index) {
        return mobileElementList.get(index);
    }

    public int getElementListSize(List<MobileElement> mobileElementList) {
        return mobileElementList.size();
    }

    public boolean validateElementInvisible(MobileElement mobileElement) {
        try {
            return !mobileElement.isDisplayed();
        } catch (NoSuchElementException exception) {
            return true;
        }
    }

}
