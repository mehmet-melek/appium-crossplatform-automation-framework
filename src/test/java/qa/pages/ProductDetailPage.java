package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.junit.Assert.assertEquals;

public class ProductDetailPage extends PageBase {
    public ProductDetailPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private static final String pageHeader ="BACK TO PRODUCTS";

    @AndroidFindBy(xpath = "//*[@content-desc='test-BACK TO PRODUCTS']/android.widget.TextView")
    private MobileElement productDetailPageHeader;

    public ProductDetailPage validateOnProductDetailPage() {
        assertEquals(pageHeader,getElementText(productDetailPageHeader));
        return this;
    }

}
