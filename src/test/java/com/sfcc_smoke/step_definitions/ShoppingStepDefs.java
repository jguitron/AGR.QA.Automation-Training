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

public class ShoppingStepDefs {
    SearchPage shoppingPage = new SearchPage();
    AccountPage signUp = new AccountPage();
    WebDriver driver = Driver.getDriver();

    @Given("User clicks on Start Shopping link")
    public void userClicksOnStartShoppinglink() {
        signUp.startShop.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User hovers over to {string} and clicks on {string}")
    public void userHoversOverToFurnitureChoosesTvStandAndClicks(String topNavItem, String subNavItem) {
        String topmenuitem = topNavItem.toLowerCase();
        BrowserUtils.hover(driver.findElement(By.xpath("(//a[@data-cgid='" + topmenuitem + "'])[1]")));
        driver.findElement(By.xpath("//li[*='" + subNavItem + "']")).click();
    }

    @When("User navigates to last page")
    public void userNavigatesToLastPage() {
        BrowserUtils.scrollToElement(shoppingPage.lastPageBtn);
        shoppingPage.lastPageBtn.click();
    }

    @Then("User chooses last available product and clicks on it")
    public void userChoosesLastAvailableProductAndClicksOnIt() {
        BrowserUtils.scrollToElement(shoppingPage.lastTvStand);
        BrowserUtils.waitForPageToLoad(3);
        shoppingPage.lastTvStand.click();
    }

    @Then("User adds 2 products to his cart")
    public void userAddsMaxAmountAllowedProductToHisCart() {
        shoppingPage.qty.click();
        BrowserUtils.sleep(1);
        shoppingPage.addToCart.click();
    }

    @Then("User checks his cart with total amount")
    public void userChecksHisCartWithTotalAmount() {
        shoppingPage.cart.click();
        String itemCount = shoppingPage.totalCount.getText();
        System.out.println("Total price for " + itemCount + "items: " + shoppingPage.totalPrice.getText());
    }
}
