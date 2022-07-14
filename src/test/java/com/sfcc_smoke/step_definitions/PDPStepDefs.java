package com.sfcc_smoke.step_definitions;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;

public class PDPStepDefs {
    ProductDetailPage productDetailPage = new ProductDetailPage();
    WebDriver driver = Driver.getDriver();
    String platform = ConfigReader.getProperty("platform");

    @When("User Select King bed size")
    public void selectBedSize() {
        BrowserUtils.clickWithJS(productDetailPage.iconkingsize);
        BrowserUtils.sleep(3);
    }
    @When("User verifies that FPP available on PDP")
    public void user_verifies_FPP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_FURNPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Furniture Protection Plan (add plan in cart)", productDetailPage.pdp_FURNPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("5 Year Furniture Protection Plan", productDetailPage.pdp_FURNPRO.getText());
        }
    }
    @When("User verifies that OUTDoorPP available on PDP")
    public void user_verifies_Out_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_OUTDRF);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Outdoor Protection Plan (add plan in cart)", productDetailPage.pdp_OUTDRF.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("5 Year Outdoor Protection Plan", productDetailPage.pdp_OUTDRF.getText());
        }
    }
    @When("User verifies that Adjustable PP available on PDP")
    public void user_verifies_Adjst_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.pp_ADJPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_ADJPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_ADJPRO.getText());
        }
    }
    @When("User verifies that KingAdjustable available on PDP")
    public void user_verifies_KAdjust_PP_available_in_PDP() {
        BrowserUtils.scrollToElement(productDetailPage.ppLableContainer);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_KADJPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_KADJPRO.getText());
        }
    }

    @When("User clicks on Add Item to Cart")
    public void user_clicks_on_add_item_to_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.waitForClickability(productDetailPage.addtocart,Duration.ofSeconds(4));
            BrowserUtils.clickWithJS(productDetailPage.addtocart);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (productDetailPage.AddToCart_mob.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
            BrowserUtils.sleep(1);
            productDetailPage.contShoppingBtnAddItmPopUp.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    @Then("User clicks on Add Item to Cart tablet and desktop skip")
    public void user_clicks_on_add_item_to_cart_tablet_and_desktop_skip() {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
        }
    }
    @Then("User clicks on Add Item to Cart mobile skip")
    public void user_clicks_on_add_item_to_cart_mobile_skip() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.scrollToElement(productDetailPage.addtocart);
            productDetailPage.addtocart.isDisplayed();
            BrowserUtils.clickWithJS(productDetailPage.addtocart);
        }
    }

    @Then("User asserts items in popup is {string} qty or item")
    public void user_asserts_items_in_popup_is_qty_item(String inputAssert) {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            String ItemName = driver.findElement(By.xpath("(//a[@title='Go to Product: " + inputAssert + "'])[3]")).getText();
            Assert.assertEquals(inputAssert, ItemName);
        }
    }

    @Then("User change qty from {int} to {int} in PDP")
    public void user_change_qty_from_to_in_pdp(Integer qty1, Integer qty2) {
        productDetailPage.pdpQTYIncrease.click();
    }
    @Then("User change qty from {int} to {int} in PDP tablet and desktop skip")
    public void user_change_qty_from_to_in_pdp_tablet_and_desktop_skip(Integer int1, Integer int2) {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            productDetailPage.pdpQTYIncrease.click();
        }
    }

    @When("User asserts {string} bed size displayed on PDP")
    public void user_asserts_bed_size_displayed_on_pdp(String mattressSize) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            String mattressSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@class='swatchanchor " + mattressSize + "']")).getText();
            String mattressOnPage = driver.findElement(By.cssSelector("h1[itemprop]")).getText();
            Assert.assertTrue(mattressOnPage.contains(mattressSelected));
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,700)");
            String mattressSelected = driver.findElement(By.xpath("//li /a[@class='swatchanchor " + mattressSize + "']")).getText();
            Assert.assertTrue(mattressSelected.toUpperCase().contains(mattressSize.toUpperCase()));
        }
    }

    @Then("User changes bed size in PDP to ones not currently displayed mattress and asserts change")
    public void user_changes_bed_size_in_pdp_to_ones_not_currently_displayed_mattress_and_asserts_change(List <String> size) {
        for (String eachSize: size) {
                BrowserUtils.clickWithJS( driver.findElement(By.xpath("//li /a[@class='swatchanchor "+eachSize+"']")));
                BrowserUtils.sleep(2);
                String mattressOnPage = driver.findElement(By.cssSelector("h1[itemprop]")).getText();
                Assert.assertTrue(mattressOnPage.toUpperCase().contains(eachSize.toUpperCase()));
            }
    }

    @When("User asserts {string} color displayed on PDP")
    public void user_asserts_color_displayed_on_pdp(String color) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            String colorSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@title='Select Color: " + color + "']")).getText();
            String colorOnPage = driver.findElement(By.xpath("//div[@class='dimension-image']/img[@alt='Darcy Loveseat, " + color + ", large']")).getText();
            Assert.assertTrue(colorOnPage.contains(colorSelected));
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,800)");
            String colorSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@title='Select Color: " + color + "']")).getText();
            String colorOnPage = driver.findElement(By.xpath("(//img[@alt='Darcy Loveseat, " + color + ", large'])[2]")).getText();
            Assert.assertTrue(colorOnPage.contains(colorSelected));
        }
    }

    @Then("User changes color scheme in PDP to ones not currently displayed by colors different colors and asserts change")
    public void user_changes_color_scheme_in_pdp_to_ones_not_currently_displayed_by_different_colors_and_asserts_change(List <String> colors) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            for (String eachColor : colors) {
                driver.findElement(By.xpath("//ul[@class='swatches clearfix color'] /li /a[@title='Select Color: " + eachColor + "']")).click();
                BrowserUtils.sleep(2);
                JavascriptExecutor Js1 = (JavascriptExecutor) driver;
                Js1.executeScript("window.scrollBy(0,400)");
                BrowserUtils.sleep(2);
                driver.findElement(By.xpath("//button[@class='toggle-attribute-values']")).click();
                BrowserUtils.sleep(2);
                String colorOnPage = driver.findElement(By.xpath("//div[@class='label'] /span[@class='selected-variant']")).getText();
                Assert.assertTrue(colorOnPage.contains(eachColor));
            }
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            for (String eachColor : colors) {
                driver.findElement(By.xpath("//ul[@class='swatches clearfix color'] /li /a[@title='Select Color: " + eachColor + "']")).click();
                BrowserUtils.sleep(2);
                JavascriptExecutor Js1 = (JavascriptExecutor) driver;
                Js1.executeScript("window.scrollBy(0,700)");
                driver.findElement(By.xpath("//button[@class='toggle-attribute-values']")).click();
                BrowserUtils.sleep(2);
                String colorOnPage = driver.findElement(By.xpath("//div[@class='label'] /span[@class='selected-variant']")).getText();
                String colorSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@title='Select Color: " + eachColor + "']")).getText();
                Assert.assertTrue(colorOnPage.contains(colorSelected));
            }
        }
    }
    @Then("User changes color scheme in quick view and asserts change mobile skip included")
    public void user_changes_color_scheme_in_quick_view_and_asserts_change_mobile_skip_included(List <String> colors) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            if (driver.findElements(By.xpath("//ul[@class='swatches clearfix color']")).isEmpty()) {
                System.out.println("no colors to change");
            } else if (driver.findElement(By.xpath("//ul[@class='swatches clearfix color']")).isDisplayed()) {
            for (String eachColor : colors) {
                BrowserUtils.clickWithJS(driver.findElement(By.xpath("//ul[@class='swatches clearfix color'] /li /a[@title='Select Color: " + eachColor + "']")));
                BrowserUtils.sleep(2);
                BrowserUtils.clickWithJS(driver.findElement(By.xpath("//button[@class='toggle-attribute-values']")));
                BrowserUtils.sleep(2);
                String colorOnPage = driver.findElement(By.xpath("//div[@class='label'] /span[@class='selected-variant']")).getText();
                Assert.assertTrue(colorOnPage.contains(eachColor));
            }
            }
        }
    }
    @Given("User clicks on Heart Icon in pdp")
    public void user_clicks_on_heart_icon_in_pdp() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            productDetailPage.heartIconPDPDeskTopTablet.click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            productDetailPage.heartIconPDPMobile.click();
        }
    }
}
