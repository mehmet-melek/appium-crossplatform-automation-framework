package qa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.pages.ProductDetailPage;
import qa.pages.ProductsPage;

public class ProductPageStepDefinitions {
    ProductsPage productsPage = new ProductsPage(DriverSetup.getDriver());
    ProductDetailPage productDetailPage = new ProductDetailPage(DriverSetup.getDriver());

    @Given("User is at the product page")
    public void user_is_at_the_product_page() {
        productsPage.validateOnProductPage();
    }

    @When("User click to product image")
    public void user_click_to_product_image() {
        productsPage.openItemFromImage();
    }

    @Then("User should see the product detail page open")
    public void user_should_see_the_product_detail_page_open() {
        productDetailPage.validateOnProductDetailPage();
    }

    @When("User click to product title")
    public void user_click_to_product_title() {
        productsPage.openItemFromTitle();
    }

    @When("User clicks on Add To Cart button")
    public void user_clicks_on_add_to_cart_button() {
        productsPage.pressAddToCardButton();
    }

    @Then("User should see Remove button instead of Add To Cart button")
    public void user_should_see_remove_button_instead_of_add_to_cart_button() {
        productsPage.validateRemoveButtonIsExist();
    }

    @Then("the number on cart icon should be {int}")
    public void the_number_on_cart_icon_should_be(Integer number) {
        productsPage.validateItemNumberOnCardIcon(String.valueOf(number));
    }

    @When("User clicks on Remove button")
    public void user_clicks_on_remove_button() {
        productsPage.pressRemoveButton();
    }

    @Then("the number on cart icon should be empty")
    public void the_number_on_cart_icon_should_be_empty() {
        productsPage.validateCardIconNumberIsEmpty();
    }
}
