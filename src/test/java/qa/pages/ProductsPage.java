package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsPage extends PageBase {

    public ProductsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    private static final String buttonNameAfterClick = "REMOVE";
    private static final String pageHeader = "PRODUCTS";

    @AndroidFindBy(xpath = "//*[@content-desc='test-Cart drop zone']/*/android.widget.TextView")
    private MobileElement productsPageHeader;

    @AndroidFindBy(xpath = "(//*[@content-desc='test-Item title'])")
    private List<MobileElement> shownProductTitles;

    @AndroidFindBy(xpath = "(//*[@content-desc='test-Item'])/*/android.widget.ImageView")
    private List<MobileElement> shownProductImages;

    @AndroidFindBy(xpath = "(//*[@content-desc='test-ADD TO CART'])/android.widget.TextView")
    private List<MobileElement> shownAddToCardButtons;

    @AndroidFindBy(xpath = "//*[@content-desc='test-REMOVE']/android.widget.TextView")
    private List<MobileElement> shownRemoveButtons;

    @AndroidFindBy(xpath = "//*[@content-desc='test-Cart']/*/android.widget.TextView")
    private MobileElement cardIconAfterItemAdded;


    public ProductsPage validateOnProductPage() {
        assertEquals(pageHeader, getElementText(productsPageHeader));
        return this;
    }


    public ProductDetailPage openItemFromImage() {
        click(shownProductImages.get(0));
        return new ProductDetailPage(driver);
    }

    public ProductDetailPage openItemFromTitle() {
        click(shownProductTitles.get(0));
        return new ProductDetailPage(driver);
    }

    public ProductsPage pressAddToCardButton() {
        click(shownAddToCardButtons.get(0));
        return this;
    }

    public void validateRemoveButtonIsExist() {
        assertEquals(buttonNameAfterClick, getElementText(shownRemoveButtons.get(0)));
    }

    public void validateItemNumberOnCardIcon(String numberOnCard) {
        assertEquals(numberOnCard, (getElementText(cardIconAfterItemAdded)));
    }

    public ProductsPage pressRemoveButton() {
        click(shownRemoveButtons.get(0));
        return this;
    }

    public ProductsPage validateCardIconNumberIsEmpty() {
        assertTrue(validateElementInvisible(cardIconAfterItemAdded));
        return this;
    }
}
