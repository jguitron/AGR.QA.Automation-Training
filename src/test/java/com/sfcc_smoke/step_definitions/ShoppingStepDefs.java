package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.SearchPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class ShoppingStepDefs {
    SearchPage shoppingPage = new SearchPage();
    AccountPage signUp = new AccountPage();
    WebDriver driver = Driver.getDriver();

    @Given("User clicks on Start Shopping link")
    public void user_clicks_on_start_shopping_link() {
        signUp.startShop.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User hovers over to {string} and clicks on {string}")
    public void user_hovers_over_to_furniture_chooses_tv_stand_and_clicks(String topNavItem, String subNavItem) {
        String topmenuitem = topNavItem.toLowerCase();
        BrowserUtils.hover(driver.findElement(By.xpath("(//a[@data-cgid='" + topmenuitem + "'])[1]")));
        driver.findElement(By.xpath("//li[*='" + subNavItem + "']")).click();
    }

    @When("User navigates to last page")
    public void user_navigates_to_last_page() {
        BrowserUtils.scrollToElement(shoppingPage.lastPageBtn);
        shoppingPage.lastPageBtn.click();
    }

    @Then("User chooses last available product and clicks on it")
    public void user_chooses_last_available_product_and_clicks_on_it() {
        BrowserUtils.scrollToElement(shoppingPage.lastTvStand);
        BrowserUtils.waitForPageToLoad(3);
        shoppingPage.lastTvStand.click();
    }

    @Then("User adds 2 products to his cart")
    public void user_adds_max_amount_allowed_product_to_his_cart() {
        shoppingPage.qty.click();
        BrowserUtils.sleep(1);
        shoppingPage.addToCart.click();
    }

    @Then("User checks his cart with total amount")
    public void user_checks_his_cart_with_total_amount() {
        shoppingPage.cart.click();
        String itemCount = shoppingPage.totalCount.getText();
        System.out.println("Total price for " + itemCount + "items: " + shoppingPage.totalPrice.getText());
    }
}
