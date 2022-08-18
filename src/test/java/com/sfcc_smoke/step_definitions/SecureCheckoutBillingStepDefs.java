package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.SecureCheckoutBilling;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecureCheckoutBillingStepDefs {
    SecureCheckoutBilling checkoutBilling = new SecureCheckoutBilling();
    WebDriver driver = Driver.getDriver();

    @Given("User is on Billing and Payment Page")
    public void userIsOnBillingAndPaymentPage() {
        Assert.assertEquals("Payment Info", checkoutBilling.BP_subtitle.getText());
    }

    @Then("Credit card Payment option is available")
    public void creditCardPaymentOptionIsAvailable() {
        BrowserUtils.scrollToElement(checkoutBilling.cclogoimg1);
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutBilling.cclogoimg1.isDisplayed());
        Assert.assertTrue(checkoutBilling.cclogoimg2.isDisplayed());
    }

    @Then("User clicks on Credit Card Payment option")
    public void userClicksOnCCLogo() {
        checkoutBilling.cclogocontainer.click();
    }

    @Then("Credit card Payment option fields are displayed")
    public void creditCardPaymentOptionFieldsAreDisplayed() {
        Assert.assertTrue(checkoutBilling.label_NameOnCard.isDisplayed());
        Assert.assertTrue(checkoutBilling.label_CC_number.isDisplayed());
        Assert.assertTrue(checkoutBilling.label_expdate.isDisplayed());
        Assert.assertTrue(checkoutBilling.label_cvv.isDisplayed());
    }

    @Then("Ashley Advantage Payment option is available")
    public void ashleyAdvantagePaymentOptionIsAvailable() {
        BrowserUtils.sleep(1);
        BrowserUtils.scrollToElement(checkoutBilling.aalogoimg);
        Assert.assertTrue(checkoutBilling.aalogoimg.isDisplayed());
    }

    @Then("User clicks on Ashley Advantage Payment option")
    public void userClicksOnAaLogo() {
        BrowserUtils.scrollToElement(checkoutBilling.aalogoimg);
        BrowserUtils.clickWithJS(checkoutBilling.aalogoimg);
    }

    @Then("Ashley Advantage Payment option logos and fields are displayed")
    public void ashleyAdvantagePaymentOptionLogoFieldsAreDisplayed() {
        BrowserUtils.sleep(2);
        //Assert.assertTrue(checkoutBilling.aatitle.isDisplayed());
        //Assert.assertEquals("Ashley Advantage™", checkoutBilling.aatitle.getText());
        Assert.assertTrue(checkoutBilling.synchronylogo.isDisplayed());
        Assert.assertTrue(checkoutBilling.genesislogo.isDisplayed());
        Assert.assertTrue(checkoutBilling.gafcologo.isDisplayed());
    }

    @Then("Progressive leasing Payment option is available")
    public void plPaymentOptionIsAvailable() {
        BrowserUtils.sleep(1);
        BrowserUtils.scrollToElement(checkoutBilling.pllogoimg);
        Assert.assertTrue(checkoutBilling.pllogoimg.isDisplayed());
    }

    @Then("User clicks on Progressive leasing Payment option")
    public void userClicksOnPLLogo() {
        BrowserUtils.clickWithJS(checkoutBilling.pllogoimg);
        BrowserUtils.sleep(2);
    }

    @Then("Progressive leasing Payment option logos and fields are displayed")
    public void plPaymentOptionLogoFieldsAreDisplayed() {
        Assert.assertTrue(checkoutBilling.pltitle.isDisplayed());
        Assert.assertEquals("Progressive Leasing™", checkoutBilling.pltitle.getText());
        Assert.assertTrue(checkoutBilling.lable_pl_ID.isDisplayed());
        Assert.assertTrue(checkoutBilling.lable_pl_SSN4.isDisplayed());
        Assert.assertTrue(checkoutBilling.btn_pl_view_dtls.isDisplayed());
    }

    @Then("User clicks on Paypal Payment option")
    public void userClicksOnPaypalLogo() {
        BrowserUtils.clickWithJS(checkoutBilling.pplogoimg);
    }

    @Then("User verifies Paypal Payment option is available")
    public void verifyPayPalOption() {
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow);
        BrowserUtils.scrollToElement(checkoutBilling.pplogoimg);
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutBilling.pplogoimg.isDisplayed());
    }

    @Then("User clicks on Caddipay Payment option")
    public void userClicksOnCaddipayLogo() {
        BrowserUtils.clickWithJS(checkoutBilling.caddipayLogo);
        BrowserUtils.sleep(3);
    }


    @Then("Caddipay Payment option is available")
    public void caddipayPaymentOptionIsAvailable() {
        BrowserUtils.scrollToElement(checkoutBilling.caddipayLogo);
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutBilling.caddipayLogo.isDisplayed());
    }


    @Then("Acima Payment option is available")
    public void acimaPaymentOptionIsAvailable() {
        BrowserUtils.scrollToElement(checkoutBilling.acimaLogo);
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutBilling.acimaLogo.isDisplayed());
    }


    @Then("User verifies that Progressive Popup for ProtectionPlan is displayed")
    public void userVerifiesProgressivePopupFPPIsDisplayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you have added a protection plan(s).\n" +
                "Protection Plans cannot be added to items that are leased.\n" +
                "\n" +
                "If you wish to keep the protection plan(s), choose another payment option.", checkoutBilling.PrgsvPopupMsg.getText());
    }

    @Then("User verifies that Progressive Popup for FPP and Handy Item is displayed")
    public void userVerifiesProgressivePopupFPPandHandyIsDisplayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you added a Protection Plan(s) and Furniture Assembly by Handy.\n" +
                "These services cannot be added to leased items.\n" +
                "\n" +
                "If you wish to keep your Expert Assembly & Installation by Handy, please choose a different payment method.", checkoutBilling.PrgsvPopupMsg_FppHandy.getText());
    }

    @Then("User verifies that Progressive Popup for Handy Item is displayed")
    public void userVerifiesProgressivePopupHandyIsDisplayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you added Furniture Assembly by Handy.\n" +
                "This service cannot be added to leased items.\n" +
                "\n" +
                "If you wish to keep your Furniture Assembly by Handy, please choose a different payment method..", checkoutBilling.PrgsvPopupMsg_handy.getText());
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive popup msg")
    public void userClicksOnContinueWithPL() {
        checkoutBilling.PrgsvPopupContinueBtn.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive FPP and Handy popup msg")
    public void userClicksOnContinueWithPLFPPHandy() {
        checkoutBilling.PrgsvPopupContinueBtnFPPHandy.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive Handy popup msg")
    public void userClicksOnContinueWithPLHandy() {
        checkoutBilling.PrgsvPopupContinueBtnHandy.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("User validates the tax amount on SecureCheckout Billing Page")
    public void userValidateTaxOnSecureCheckoutBilling() {
        BrowserUtils.sleep(2);
        BrowserUtils.scrollToElement(checkoutBilling.TaxLabelSecureCheckOutBilling);
        Assert.assertTrue(checkoutBilling.TaxLabelSecureCheckOutBilling.isDisplayed());
        String zipcode = checkoutBilling.zipcodevalueBilling.getAttribute("value");
        String taxvalue = checkoutBilling.taxValueSecureCheckoutBilling.getText();
        taxvalue = taxvalue.replace("$", "");
        double finaltaxvalue = Double.parseDouble(taxvalue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
            Assert.assertTrue(finaltaxvalue == 0.00);
        } else {
            Assert.assertTrue(finaltaxvalue > 0);
        }
    }

    @When("User Verifies Recycle Fee is displayed on SecureCheckOut Billing Page only for CA store")
    public void userVerifiesRecycleFeeDisplayedBillingPage() {
        BrowserUtils.sleep(1);
        String zipcode = checkoutBilling.zipcodevalueBilling.getAttribute("value");
        if (zipcode.startsWith("90")) {
            BrowserUtils.scrollToElement(checkoutBilling.recycleFeeLabelBilling);
            Assert.assertTrue(checkoutBilling.recycleFeeLabelBilling.isDisplayed());
            String recyclefee = checkoutBilling.recycleFeeValueBilling.getText();
            recyclefee = recyclefee.replace("$", "");
            double recyclefeeamount = Double.parseDouble(recyclefee);
            Assert.assertTrue(recyclefeeamount > 0);
            BrowserUtils.sleep(1);
        } else {
            WebDriver driver = Driver.getDriver();
            List<WebElement> elements = driver.findElements(By.xpath("//tr[@id='order-state-recycling-fee']/td[2]"));
            Assert.assertTrue(elements.size() == 0);
        }
    }
}
