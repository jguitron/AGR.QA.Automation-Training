package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PDPStepDefs {

    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    BrowserUtils browserUtils = new BrowserUtils();

    @When("User adds items to cart")
    public void additemtocart() {
        browserUtils.scrollToElement(productDetailPage.addtocart);
        productDetailPage.addtocart.click();
    }

    @When("User Select King bed size")
    public void selectbedsize() {
        productDetailPage.iconkingsize.click();
        BrowserUtils.sleep(3);
    }

    @When("User verifies that FPP available on PDP")
    public void user_verifies_FPP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_FURNPRO);
        Assert.assertEquals("5 Year Furniture Protection Plan (add plan in cart)", productDetailPage.pdp_FURNPRO.getText());
        System.out.println("Verified: " + productDetailPage.pdp_FURNPRO.getText());
    }

    @When("User verifies that OUTDoorPP available on PDP")
    public void user_verifies_Out_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_OUTDRF);
        Assert.assertEquals("5 Year Outdoor Protection Plan (add plan in cart)", productDetailPage.pdp_OUTDRF.getText());
        System.out.println("Verified: " + productDetailPage.pdp_OUTDRF.getText());
    }

    @When("User verifies that Adjustable PP available on PDP")
    public void user_verifies_Adjst_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pp_ADJPRO);
        Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_ADJPRO.getText());
        System.out.println("Verified: " + productDetailPage.pp_ADJPRO.getText());
    }

    @When("User verifies that KingAdjustable available on PDP")
    public void user_verifies_KAdjust_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_KADJPRO);
        Assert.assertEquals("10 Year King Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pdp_KADJPRO.getText());
        System.out.println("Verified: " + productDetailPage.pdp_KADJPRO.getText());

    }
}
