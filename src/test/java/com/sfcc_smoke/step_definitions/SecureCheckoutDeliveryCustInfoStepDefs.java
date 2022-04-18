package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutDeliveryCustInfo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class SecureCheckoutDeliveryCustInfoStepDefs {

    SecureCheckoutDeliveryCustInfo custInfo = new SecureCheckoutDeliveryCustInfo();

    @When("User enters customer info {string} , {string} ,{string}, {string}, {string}, {string}, {string}, {string}, {string} on Secure Checkout Delivery Page")
    public void user_enters_customer_info_on_secure_checkout_delivery_page(String Fname, String Lname, String Address1, String Address2, String City, String State, String Zip, String Phone, String Email) {
        custInfo.fname.sendKeys(Fname);
        custInfo.lname.sendKeys(Lname);
        custInfo.address1.sendKeys(Address1);
        custInfo.address2.sendKeys(Address2);
        custInfo.city.sendKeys(City);
        custInfo.state.sendKeys(State);
        custInfo.zip.clear();
        custInfo.zip.sendKeys(Zip);
        custInfo.customerphone.sendKeys(Phone);
        custInfo.customeremail.sendKeys(Email);
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

    @Then("user clicks on {string}")
    public void userClicksOn(String arg0) {

    }
}
