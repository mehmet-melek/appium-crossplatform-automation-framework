package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


import static org.junit.Assert.assertEquals;

public class LoginPage extends PageBase {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(accessibility = "test-Username")
    private MobileElement userNameTextField;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(accessibility = "test-Password")
    private MobileElement passwordTextField;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(accessibility = "test-LOGIN" )
    private MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='test-Error message']")
    private MobileElement loginErrorMessage;

    public LoginPage enterUserName(String userName) {
        sendKeys(userNameTextField, userName);
        return this;
    }

    public LoginPage enterUserPassword(String password) {
        sendKeys(passwordTextField, password);
        return this;
    }

    public ProductsPage pressLoginButton() {
        click(loginButton);
        return new ProductsPage(driver);
    }

    public void validateErrorMessage(String errorMessage) {
        assertEquals(errorMessage,getElementText(loginErrorMessage));
    }

    public ProductsPage directLogin(String validUserName, String validPassword) {
        enterUserName(validUserName).enterUserPassword(validPassword).pressLoginButton();
        return new ProductsPage(driver);
    }

}
