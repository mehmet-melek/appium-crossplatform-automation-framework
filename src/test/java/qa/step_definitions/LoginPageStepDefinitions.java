package qa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.pages.LoginPage;
import qa.pages.ProductsPage;


public class LoginPageStepDefinitions {
    LoginPage loginPage = new LoginPage(DriverSetup.getDriver());
    ProductsPage productsPage = new ProductsPage(DriverSetup.getDriver());

    @Given("User is at the login page")
    public void user_is_at_the_login_page() {

    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String userName, String password) {
        loginPage.enterUserName(userName)
                .enterUserPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.pressLoginButton();
    }

    @Then("User is able to successfully login to application.")
    public void user_is_able_to_successfully_login_to_application() {
        productsPage.validateOnProductPage();
    }

    @Then("User should see {string} error message")
    public void user_should_see_error_message(String errorMessage) {
        loginPage.validateErrorMessage(errorMessage);
    }
}


