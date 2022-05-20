package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutDeliveryCustInfo;
import com.sfcc_smoke.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SecureCheckoutDeliveryCustInfoStepDefs {
    SecureCheckoutDeliveryCustInfo custInfo = new SecureCheckoutDeliveryCustInfo();

    @When("User enters customer info on Secure Checkout Delivery Page")
    public void enterCustomerInfoOnSecureCheckoutDeliveryPage(List<String> info) {
        String customerInfo = "";
        List<String> mylist = info;
        for (int i = 0; i < mylist.size(); i++) {
            customerInfo = mylist.get(i);
            if (i == 0) {
                custInfo.fname.sendKeys(customerInfo);
            }
            if (i == 1) {
                custInfo.lname.sendKeys(customerInfo);
            }
            if (i == 2) {
                custInfo.address1.sendKeys(customerInfo);
            }
            if (i == 3) {
                custInfo.address2.sendKeys(customerInfo);
            }
            if (i == 4) {
                custInfo.city.sendKeys(customerInfo);
            }
            if (i == 5) {
                custInfo.state.sendKeys(customerInfo);
            }
            if (i == 6) {
                custInfo.zip.clear();
                custInfo.zip.sendKeys(customerInfo);
            }
            if (i == 7) {
                custInfo.customerphone.sendKeys(customerInfo);
            }
            if (i == 8) {
                custInfo.customeremail.sendKeys(customerInfo);
            }
        }
    }

    @When("User clicks on Continue as Guest button")
    public void click_on_Cont_as_guest() {
        custInfo.contAsGuest.click();
    }

    @When("User clicks on Use Original button on PopUp window")
    public void click_on_useoriginal() {
        custInfo.useoriginal.click();
    }

    @Then("User validates the tax amount on SecureCheckout CustomerInfo Page")
    public void user_validate_tax_on_SecureCheckout_CustInfo() {
        BrowserUtils.sleep(2);
        String zipcode = custInfo.zip.getAttribute("value");
        BrowserUtils.scrollToElement(custInfo.taxLableSecureChkoutCustInfo);
        String taxvalue = custInfo.taxValueSecureChkoutCustInfo.getText();
        taxvalue = taxvalue.replace("$", "");
        double finaltaxvalue = Double.parseDouble(taxvalue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
            Assert.assertTrue(finaltaxvalue == 0.00);
        } else {
            Assert.assertTrue(finaltaxvalue > 0);
        }
    }
}
