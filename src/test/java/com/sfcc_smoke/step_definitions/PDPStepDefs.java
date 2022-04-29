package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PDPStepDefs {
    CartPage cartPage = new CartPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    String platform = ConfigReader.getProperty("platform");

    @When("User Select King bed size")
    public void selectBedSize() {
        if (platform.equals("desktop") || (platform.equals("tablet"))) {
            productDetailPage.iconkingsize.click();
        }
        if (platform.equals("mobile")){
            BrowserUtils.clickWithJS(productDetailPage.iconkingsize);
        }
        BrowserUtils.sleep(3);
    }

    @When("User verifies that FPP available on PDP")
    public void user_verifies_FPP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_FURNPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Furniture Protection Plan (add plan in cart)", productDetailPage.pdp_FURNPRO.getText());
        }
        else if (platform.equals("mobile") || (platform.equals("tablet"))){
            Assert.assertEquals("5 Year Furniture Protection Plan", productDetailPage.pdp_FURNPRO.getText());
        }
    }

    @When("User verifies that OUTDoorPP available on PDP")
    public void user_verifies_Out_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_OUTDRF);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Outdoor Protection Plan (add plan in cart)", productDetailPage.pdp_OUTDRF.getText());
        }
        else if (platform.equals("mobile") || (platform.equals("tablet"))){
            Assert.assertEquals("5 Year Outdoor Protection Plan", productDetailPage.pdp_OUTDRF.getText());
        }
    }

    @When("User verifies that Adjustable PP available on PDP")
    public void user_verifies_Adjst_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pp_ADJPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_ADJPRO.getText());
        }
        else if (platform.equals("mobile") || (platform.equals("tablet"))){
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_ADJPRO.getText());
        }
    }

    @When("User verifies that KingAdjustable available on PDP")
    public void user_verifies_KAdjust_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.ppLableContainer);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_KADJPRO.getText());
        }
        else if (platform.equals("mobile") || (platform.equals("tablet"))){
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_KADJPRO.getText());
        }
    }

    @When("User clicks on Add Item to Cart")
    public void user_clicks_on_add_item_to_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.scrollToElement(productDetailPage.addtocart);
            productDetailPage.addtocart.isDisplayed();
            BrowserUtils.clickWithJS(productDetailPage.addtocart);
        }
        else if (productDetailPage.AddToCart_mob.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
            cartPage.mobAddedToCartPopUpContShoppingBtn.click();
        }
    }
}
