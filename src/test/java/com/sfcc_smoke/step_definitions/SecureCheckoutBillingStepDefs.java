package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutBilling;
import com.sfcc_smoke.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SecureCheckoutBillingStepDefs {

    SecureCheckoutBilling checkoutBilling = new SecureCheckoutBilling();

    @Given("User is on Billing and Payment Page")
    public void user_is_on_billing_and_payment_page() {
        Assert.assertEquals("2 Billing & Payment", checkoutBilling.BP_subtitle.getText());
        System.out.println(checkoutBilling.BP_subtitle.getText());
    }

    @Then("Credit card Payment option is available")
    public void credit_card_payment_option_is_available() {
        Assert.assertTrue(checkoutBilling.cclogoimg1.isDisplayed());
        System.out.println("CC logo image1 is displayed: " + checkoutBilling.cclogoimg1.isDisplayed());
        Assert.assertTrue(checkoutBilling.cclogoimg2.isDisplayed());
        System.out.println("CC logo image2 is displayed: " + checkoutBilling.cclogoimg2.isDisplayed());
    }

    @Then("User clicks on Credit Card Payment option")
    public void user_clicks_on_CC_logo() {
        checkoutBilling.cclogocontainer.click();
    }

    @Then("Credit card Payment option fields are displayed")
    public void credit_card_payment_option_fields_are_displayed() {
        Assert.assertTrue(checkoutBilling.label_NameOnCard.isDisplayed());
        System.out.println("Name on the Card field: " + checkoutBilling.label_NameOnCard.isDisplayed());
        Assert.assertTrue(checkoutBilling.label_CC_number.isDisplayed());
        System.out.println("Credit card number field: " + checkoutBilling.label_CC_number.isDisplayed());
        Assert.assertTrue(checkoutBilling.label_expdate.isDisplayed());
        System.out.println("Exp date field: " + checkoutBilling.label_expdate.isDisplayed());
        Assert.assertTrue(checkoutBilling.label_cvv.isDisplayed());
        System.out.println("CVV field: " + checkoutBilling.label_cvv.isDisplayed());
    }

    @Then("Ashley Advantage Payment option is available")
    public void ashley_advantage_payment_option_is_available() {
        Assert.assertTrue(checkoutBilling.aalogoimg.isDisplayed());
        System.out.println("CC logo image1 is displayed: " + checkoutBilling.aalogoimg.isDisplayed());
    }

    @Then("User clicks on Ashley Advantage Payment option")
    public void user_clicks_on_aaLogo() {
        checkoutBilling.aalogoimg.click();
    }

    @Then("Ashley Advantage Payment option logos and fields are displayed")
    public void ashley_advantage_payment_option_logo_fields_are_displayed() {
        Assert.assertTrue(checkoutBilling.aatitle.isDisplayed());
        Assert.assertEquals("Ashley Advantage™", checkoutBilling.aatitle.getText());
        System.out.println("AA Title field: " + checkoutBilling.aatitle.getText());
        Assert.assertTrue(checkoutBilling.synchronylogo.isDisplayed());
        System.out.println("Synchrony logo is displayed: " + checkoutBilling.synchronylogo.isDisplayed());
        Assert.assertTrue(checkoutBilling.genesislogo.isDisplayed());
        System.out.println("Genesis logo is displayed: " + checkoutBilling.genesislogo.isDisplayed());
        Assert.assertTrue(checkoutBilling.gafcologo.isDisplayed());
        System.out.println("GAFCO logo is displayed: " + checkoutBilling.gafcologo.isDisplayed());

    }

    @Then("Progressive leasing Payment option is available")
    public void pl_payment_option_is_available() {
        Assert.assertTrue(checkoutBilling.pllogoimg.isDisplayed());
        System.out.println("PL logo image is displayed: " + checkoutBilling.pllogoimg.isDisplayed());
    }

    @Then("User clicks on Progressive leasing Payment option")
    public void user_clicks_on_PL_Logo() {
        checkoutBilling.pllogoimg.click();
    }

    @Then("Progressive leasing Payment option logos and fields are displayed")
    public void pl_payment_option_logo_fields_are_displayed() {
        Assert.assertTrue(checkoutBilling.pltitle.isDisplayed());
        Assert.assertEquals("Progressive Leasing™", checkoutBilling.pltitle.getText());
        System.out.println("PL Title field: " + checkoutBilling.pltitle.getText());
        Assert.assertTrue(checkoutBilling.lable_pl_ID.isDisplayed());
        System.out.println("Progressive Leasing ID field is displayed: " + checkoutBilling.lable_pl_ID.isDisplayed());
        Assert.assertTrue(checkoutBilling.lable_pl_SSN4.isDisplayed());
        System.out.println("Last 4 SSN field is displayed: " + checkoutBilling.lable_pl_SSN4.isDisplayed());
        Assert.assertTrue(checkoutBilling.btn_pl_view_dtls.isDisplayed());
        System.out.println("View Leasing Details button is displayed: " + checkoutBilling.btn_pl_view_dtls.isDisplayed());
    }

    @Then("Paypal Payment option is available")
    public void Paypal_payment_option_is_available() {
        Assert.assertTrue(checkoutBilling.pplogoimg.isDisplayed());
        System.out.println("PL logo image is displayed: " + checkoutBilling.pllogoimg.isDisplayed());
    }

    @Then("User clicks on Paypal Payment option")
    public void user_clicks_on_Paypal_Logo() {
        checkoutBilling.pplogoimg.click();
    }

    @Then("User verifies that Progressive Popup for ProtectionPlan is displayed")
    public void user_verifies_progressive_popup_FPP_is_displayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you have added a protection plan(s).\n" +
                "Protection Plans cannot be added to items that are leased.\n" +
                "\n" +
                "If you wish to keep the protection plan(s), choose another payment option.", checkoutBilling.PrgsvPopupMsg.getText());
        System.out.println(checkoutBilling.PrgsvPopupMsg.getText());
    }

    @Then("User verifies that Progressive Popup for Handy Item is displayed")
    public void user_verifies_progressive_popup_Handy_is_displayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you have added Expert Assembly & Installation by Handy.\n" +
                "Expert Assembly & Installation by Handy cannot be added to leased items.\n" +
                "\n" +
                "If you wish to keep your Expert Assembly & Installation by Handy, please choose a different payment method.", checkoutBilling.PrgsvPopupMsg_handy.getText());
        System.out.println(checkoutBilling.PrgsvPopupMsg_handy.getText());
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive popup msg")
    public void user_clicks_on_continue_with_PL() {
        checkoutBilling.PrgsvPopupContinueBtn.click();
        BrowserUtils.waitForPageToLoad(4);
    }

}
