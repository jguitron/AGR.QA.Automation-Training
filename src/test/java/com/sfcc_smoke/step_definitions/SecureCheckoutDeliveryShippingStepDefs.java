package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutDeliveryShipping;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

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
        taxvalue = taxvalue.replace("$", "");
        double finaltaxvalue = Double.parseDouble(taxvalue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
            Assert.assertTrue(finaltaxvalue == 0.00);
        } else {
            Assert.assertTrue(finaltaxvalue > 0);
        }
    }

    @When("User Verifies Recycle Fee is displayed on SecureCheckOut Shipping Page only for CA store")
    public void user_verifies_recycleFee_displayed_ShippingPage() {
        BrowserUtils.waitForPageToLoad(10);
        String zipcode = deliveryShipping.zipcodevalue.getAttribute("value");
        if (zipcode.startsWith("90")) {
            BrowserUtils.scrollToElement(deliveryShipping.recycleFeeLabelShipping);
            BrowserUtils.sleep(1);
            Assert.assertTrue(deliveryShipping.recycleFeeLabelShipping.isDisplayed());
            BrowserUtils.sleep(1);
            String recyclefee = deliveryShipping.recycleFeeValueShipping.getText();
            recyclefee = recyclefee.replace("$", "");
            double recyclefeeamount = Double.parseDouble(recyclefee);
            Assert.assertTrue(recyclefeeamount > 0);
            Assert.assertEquals("Would you like a pickup of your used mattress and/or foundation to be recycled, at no additional cost? (required) Learn More", deliveryShipping.recycleTakeBackMsgShipping.getText());
            BrowserUtils.scrollToElement(deliveryShipping.takebackRadioBtnYES);
            Assert.assertTrue(deliveryShipping.takebackRadioBtnYES.isDisplayed());
            Assert.assertTrue(deliveryShipping.takebackRadioBtnNO.isDisplayed());
            BrowserUtils.clickWithJS(deliveryShipping.takebackRadioBtnYES);
            BrowserUtils.sleep(1);
        } else {
            WebDriver driver = Driver.getDriver();
            List<WebElement> elements = driver.findElements(By.xpath("//tr[@id='order-state-recycling-fee']/td[2]"));
            Assert.assertTrue(elements.size() == 0);
        }
    }
}
