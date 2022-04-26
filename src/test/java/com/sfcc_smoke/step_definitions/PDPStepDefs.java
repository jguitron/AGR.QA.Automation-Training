package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PDPStepDefs {

    ProductDetailPage productDetailPage = new ProductDetailPage();
    WebDriver driver = Driver.getDriver();


    @When("User adds items to cart")
    public void addItemToCart() {
        BrowserUtils.scrollToElement(productDetailPage.addtocart);
        productDetailPage.addtocart.click();
    }

    @When("User Select King bed size")
    public void selectBedSize() {
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

    @When("User clicks on Add Item to Cart")
    public void user_clicks_on_add_item_to_cart() {
        String currentHandle = driver.getWindowHandle();
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            productDetailPage.addtocart.isDisplayed();
            productDetailPage.addtocart.click();
        }
        /**mobile has different webelement for add to cart*/
        else if (productDetailPage.AddToCart_mob.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
        }
    }
}
