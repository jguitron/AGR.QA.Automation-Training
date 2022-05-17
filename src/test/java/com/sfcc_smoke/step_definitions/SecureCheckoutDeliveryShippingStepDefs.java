package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutDeliveryShipping;
import com.sfcc_smoke.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.sound.midi.Soundbank;

public class SecureCheckoutDeliveryShippingStepDefs {
    SecureCheckoutDeliveryShipping deliveryShipping = new SecureCheckoutDeliveryShipping();

    @When("User clicks on continue to billing and payment button")
    public void click_on_Cont_to_Billing() {
        deliveryShipping.ContinueBilling.click();
    }

    @Then("User validates the tax amount on SecureCheckout Shipping Page")
    public void user_validate_tax_on_SecureCheckout_Shipping() {
        BrowserUtils.scrollToElement(deliveryShipping.TaxLabelSecureCheckOutShipping);
        Assert.assertTrue(deliveryShipping.zipSecureCheckoutShipping.isDisplayed());
        String zipcode = deliveryShipping.zipcodevalue.getAttribute("value");
        //System.out.println("Expected zipcode: " + zipcode);
        String taxvalue = deliveryShipping.taxValueSecureCheckoutShipping.getText();
        taxvalue = taxvalue.replace("$","");
        double finaltaxvalue = Double.parseDouble(taxvalue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")){
            Assert.assertTrue(finaltaxvalue == 0.00);
            System.out.println(finaltaxvalue);
        }
        else {
            Assert.assertTrue(finaltaxvalue>0);
            System.out.println(finaltaxvalue);
        }
    }
}
