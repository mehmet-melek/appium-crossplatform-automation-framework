package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


import static org.junit.Assert.assertEquals;

public class ProductDetailPage extends PageBase {
    public ProductDetailPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private static final String pageHeader ="BACK TO PRODUCTS";

    @AndroidFindBy(xpath = "//*[@content-desc='test-BACK TO PRODUCTS']/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "test-BACK TO PRODUCTS")
    private MobileElement productDetailPageHeader;

    public ProductDetailPage validateOnProductDetailPage() {
        assertEquals(pageHeader,getElementText(productDetailPageHeader));
        return this;
    }

}
