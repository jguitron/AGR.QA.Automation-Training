package com.sfcc_smoke.step_definitions;


import com.sfcc_smoke.pages.SecureCheckoutDeliveryShipping;
import io.cucumber.java.en.When;

public class SecureCheckoutDeliveryShippingStepDefs {
    SecureCheckoutDeliveryShipping deliveryShipping = new SecureCheckoutDeliveryShipping();

    @When("User clicks on continue to billing and payment button")
    public void click_on_Cont_to_Billing() {
        deliveryShipping.ContinueBilling.click();

    }
}
