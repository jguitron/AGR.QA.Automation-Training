package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutDeliveryCustInfo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class SecureCheckoutDeliveryCustInfoStepDefs {

    SecureCheckoutDeliveryCustInfo custInfo = new SecureCheckoutDeliveryCustInfo();

    @When("User enters customer info on Secure Checkout Delivery Page")
    public void enterCustomerInfoOnSecureCheckoutDeliveryPage(String firstName, String lastName, String address1, String address2,
                                                              String city, String state, String zip, String customerPhone, String customerEmail) {
            custInfo.fname.sendKeys(firstName);
            custInfo.lname.sendKeys(lastName);
            custInfo.address1.sendKeys(address1);
            custInfo.address2.sendKeys(address2);
            custInfo.city.sendKeys(city);
            custInfo.state.sendKeys(state);
            custInfo.zip.sendKeys(zip);
            custInfo.customerphone.sendKeys(customerPhone);
            custInfo.customeremail.sendKeys(customerEmail);
    }

    @When("User clicks on Continue as Guest button")
    public void click_on_Cont_as_guest() {
        custInfo.contAsGuest.click();
    }

    @When("User clicks on Use Original button on PopUp window")
    public void click_on_useoriginal() {
        custInfo.useoriginal.click();
    }

    @When("User clicks on {string} button")
    public void click_on_Cont_as_guest(WebElement guestBtn) {
        guestBtn = custInfo.contAsGuest;
        guestBtn.click();
    }

    @Then("User verifies that {string} available on PDP htht")
    public void userVerifiesThatAvailableOnPDPHtht(String arg0) {

    }

}
