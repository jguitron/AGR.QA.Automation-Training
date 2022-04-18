package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartPageDefs {

    CartPage cartPage = new CartPage();

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

    @When("user verifies that protection plan is available on cart")
    public void user_verifies_that_protection_plan_is_available_on_cart() {
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel1.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel2.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel3.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel4.getText());
    }

    @When("user verifies that protection plan is selected")
    public void user_verifies_PP_selected() {
        Assert.assertTrue(cartPage.ppckbx1.isSelected());
        System.out.println("Verified checkbox: " + cartPage.ppckbx1.isSelected());
    }

    @When("user verifies that protection plan is unselected")
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
        ;
        BrowserUtils.sleep(2);
    }

    @When("User clicks on Secure Check out button")
    public void user_clicks_secure_checkout_button() {
        cartPage.secureckoutbtn.click();
        BrowserUtils.sleep(2);
    }

    @When("User remove item from cart")
    public void user_remove_item_from_cart() {
        cartPage.removeitem.click();
        cartPage.removeitem_YesBtn.click();
        BrowserUtils.sleep(2);
    }
}
