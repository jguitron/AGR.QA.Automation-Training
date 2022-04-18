package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.SecureCheckoutDeliveryShipping;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SecureCheckoutDeliveryShippingStepDefs {

    WebDriver driver = Driver.getDriver();
    SecureCheckoutDeliveryShipping deliveryShipping = new SecureCheckoutDeliveryShipping();

    @When("User clicks on continue to billing and payment button")
    public void click_on_Cont_to_Billing(){
        deliveryShipping.ContinueBilling.click();
    }

}
