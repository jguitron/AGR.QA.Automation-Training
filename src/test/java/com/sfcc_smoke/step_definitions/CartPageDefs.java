package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartPageDefs {

    CartPage cartPage = new CartPage();
    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("User uncheck Protection Plan check box")
    public void user_uncheck_PP_checkbox() {
        BrowserUtils.waitForPageToLoad(5);
        if (cartPage.pp_checkbox.isSelected()) {
            System.out.println("try to uncheck pp checkbox");
            cartPage.pp_checkbox_cont.click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User check Protection Plan check box")
    public void user_check_PP_checkbox() {
        if (cartPage.pp_checkbox.isSelected()) {
            System.out.println("do nothing");
        } else
            cartPage.pp_checkbox.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User uncheck Handy Item check box")
    public void user_uncheck_handy_checkbox() {
        if (cartPage.handy_checkbox.isSelected()) {
            cartPage.handy_checkbox.click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User check Handy Item check box")
    public void user_check_handy_checkbox() {
        if (cartPage.handy_checkbox.isSelected()) {
            System.out.println("do nothing");
        } else
            System.out.println("try to click-checkbox handy");
        cartPage.handy_checkbox.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User verifies that {string} is added to cart")
    public void user_verifies_that_FPP_added_cart(String ProtectionPlan) {
        Assert.assertEquals("Furniture $49.99", cartPage.pplink1.getText());
        System.out.println("Verified: " + cartPage.pplink1.getText());
        Assert.assertEquals("Outdoor $179.99", cartPage.pplink2.getText());
        System.out.println("Verified: " + cartPage.pplink2.getText());
        Assert.assertEquals("Adjustable Base $149.99", cartPage.pplink3.getText());
        System.out.println("Verified: " + cartPage.pplink3.getText());
        Assert.assertEquals("King Adjustable Base $199.99", cartPage.pplink4.getText());
        System.out.println("Verified: " + cartPage.pplink4.getText());
    }

    @When("User verifies that Protection Plan is not available")
    public void user_verifies_that_FPP_unavailable() {
        Assert.assertEquals("OUR APOLOGIES: Protection plans are currently unavailable", cartPage.nofpp.getText());
        System.out.println("Verified: " + cartPage.nofpp.getText());
    }

    @When("User verifies that protection plan is available on cart")
    public void user_verifies_that_protection_plan_is_available_on_cart() {
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel1.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel2.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel3.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel4.getText());
    }

    @When("User verifies that protection plan is selected")
    public void user_verifies_PP_selected() {
        Assert.assertTrue(cartPage.ppckbx1.isSelected());
        System.out.println("Verified checkbox: " + cartPage.ppckbx1.isSelected());
    }

    @When("User verifies that protection plan is unselected")
    public void user_verifies_PP_unselected() {
        Assert.assertFalse(cartPage.ppckbx1.isSelected());
        Assert.assertFalse(cartPage.ppckbx2.isSelected());
        Assert.assertFalse(cartPage.ppckbx3.isSelected());
        Assert.assertFalse(cartPage.ppckbx4.isSelected());
        System.out.println("Verified checkbox: " + cartPage.ppckbx4.isSelected());
    }

    @When("User Verifies Recycle Fee is displayed")
    public void user_verifies_recycleFee_displayed() {
        System.out.println(cartPage.recycleFee_cart.getText());
        BrowserUtils.sleep(2);
    }

    @When("User clicks on Secure Check out button")
    public void user_clicks_secure_checkout_button() {
        cartPage.secureckoutbtn.click();
        BrowserUtils.sleep(2);
    }

    @Then("User changes Qty from 1 to 2 in cart")
    public void user_changes_qty_from_to_in_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity']")).click();
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//option[@value='2']")));
            driver.findElement(By.xpath("//option[@value='2']")).click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            BrowserUtils.sleep(3);
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity']")).click();
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//option[@value='2']")));
            driver.findElement(By.xpath("//option[@value='2']")).click();
        }
    }

    @Then("Assert total number of items in cart is {int}")
    public void assert_total_number_of_items_in_cart_is(Integer int1) {
        String MyCart = driver.findElement(By.xpath("//h1[@class='cart-title']")).getText();
        System.out.println(MyCart);
        String expectedQty = "My Cart (2 items)";
        Assert.assertEquals(expectedQty, MyCart);
    }

    @When("User Removes item from cart")
    public void user_removes_item_from_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            cartPage.removeitem.click();
            cartPage.removeitem_YesBtn.click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.removeItem_BtnMobileTablet.click();
            cartPage.removeitem_YesBtn.click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(driver.findElement(By.className("handy-head")));
            cartPage.removeItem_BtnMobileTablet.click();
            cartPage.removeitem_YesBtn.click();
        }
    }

    @Then("User Validates cart is {int} qty")
    public void user_validates_cart_is_qty(Integer int1) {
        String actualQty = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        String expectedQty = "Your Shopping Cart is Empty";
        Assert.assertTrue(expectedQty, actualQty.contains("Your Shopping Cart is Empty"));
    }

    @And("User Logs in")
    public void userLogsIn() {
        BrowserUtils.sleep(3);
        productDetailPage.EmailAddressLogin.click();
        productDetailPage.EmailAddressLogin.sendKeys("jguitron@ashleyfurniture.com");
        productDetailPage.PassWordLogin.click();
        productDetailPage.PassWordLogin.sendKeys("Tester123!");
        BrowserUtils.sleep(3);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@style='font-weight:bold;']")));
        driver.findElement(By.name("dwfrm_login_login")).click();
    }

    @Then("User asserts {string} saved items in cart")
    public void user_asserts_saved_items_in_cart(String item) {
        String SavedItem = driver.findElement(By.cssSelector("h2 a[tabindex='0']")).getText();
        String expectedItem = item;
        Assert.assertEquals(expectedItem, SavedItem);
    }

    @Then("User clicks save for later button")
    public void user_clicks_save_for_later_button() {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,700)");
        productDetailPage.SaveItem.click();
    }

    @Then("User asserts {string} saved items in cart")
    public void user_asserts_saved_items_in_cart(String item) {
        String SavedItem = driver.findElement(By.cssSelector("h2 a[tabindex='0']")).getText();
        String expectedItem = item;
        Assert.assertEquals(expectedItem, SavedItem);
    }

}

