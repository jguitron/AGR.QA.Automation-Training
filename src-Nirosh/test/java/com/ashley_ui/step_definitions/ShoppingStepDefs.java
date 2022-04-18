 package com.ashley_ui.step_definitions;

 import com.ashley_ui.pages.SearchPage;
 import com.ashley_ui.pages.SignUpPage;
 import com.ashley_ui.utilities.BrowserUtils;
 import io.cucumber.java.en.Given;
 import io.cucumber.java.en.Then;
 import io.cucumber.java.en.When;


 public class ShoppingStepDefs {

    SearchPage shoppingPage = new SearchPage();
    SignUpPage signUpPage = new SignUpPage();

    @Given("user clicks on {string} link")
    public void user_clicks_on_start_shopping_link(String startShopping) {
        signUpPage.startShop.click();
    }

    @When("user hovers over to {string}, chooses {string} and clicks")
    public void user_hovers_over_to_furniture_chooses_tv_stand_and_clicks(String furniture, String tvStand) {
        BrowserUtils.hover((shoppingPage.furniture));
        shoppingPage.tvStand.click();
    }

    @When("user navigates to last page")
    public void user_navigates_to_last_page() {
        BrowserUtils.scrollToElement(shoppingPage.lastPageBtn);
        shoppingPage.lastPageBtn.click();
    }

    @Then("user chooses last available product and clicks on it")
    public void user_chooses_last_available_product_and_clicks_on_it() {
        BrowserUtils.scrollToElement(shoppingPage.lastTvStand);
        BrowserUtils.waitForPageToLoad(3);
        shoppingPage.lastTvStand.click();
    }

    @Then("user adds 2 products to his cart")
    public void user_adds_max_amount_allowed_product_to_his_cart() {
        shoppingPage.qty.click();
        BrowserUtils.sleep(1);
        shoppingPage.addToCart.click();
    }

    @Then("user checks his cart with total amount")
    public void user_checks_his_cart_with_total_amount() {
        shoppingPage.cart.click();
        String itemCount = shoppingPage.totalCount.getText();
        System.out.println("Total price for " + itemCount + "items: " + shoppingPage.totalPrice.getText());
    }

}
