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
    public void userVerifiesFPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_FURNPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Furniture Protection Plan (add plan in cart)", productDetailPage.pdp_FURNPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("5 Year Furniture Protection Plan", productDetailPage.pdp_FURNPRO.getText());
        }
    }

    @When("User verifies that OUTDoorPP available on PDP")
    public void userVerifiesOutPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_OUTDRF);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Outdoor Protection Plan (add plan in cart)", productDetailPage.pdp_OUTDRF.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("5 Year Outdoor Protection Plan", productDetailPage.pdp_OUTDRF.getText());
        }
    }

    @When("User verifies that Adjustable PP available on PDP")
    public void userVerifiesAdjstPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.pp_ADJPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_ADJPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_ADJPRO.getText());
        }
    }

    @When("User verifies that KingAdjustable available on PDP")
    public void userVerifiesKAdjustPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.ppLableContainer);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_KADJPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_KADJPRO.getText());
        }
    }

    @When("User clicks on Add Item to Cart")
    public void userClicksOnAddItemToCart() {
        if (platform.equals("desktop") || platform.equals("tablet")) {
            BrowserUtils.waitForClickability(productDetailPage.addtocart, Duration.ofSeconds(4)).click();
//            BrowserUtils.clickWithJS(productDetailPage.addtocart);
            BrowserUtils.sleep(1);
            int cartSize = Integer.parseInt(driver.findElement(By.cssSelector("span[class='minicart-quantity']")).getText());
            Assert.assertTrue(cartSize > 0);
        } else if (productDetailPage.AddToCart_mob.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
            BrowserUtils.sleep(1);
            productDetailPage.contShoppingBtnAddItmPopUp.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    @Then("User clicks on Add Item to Cart tablet and desktop skip")
    public void userClicksOnAddItemToCartTabletAndDesktopSkip() {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(productDetailPage.AddToCart_mob);
            productDetailPage.AddToCart_mob.click();
        }
    }

    @Then("User clicks on Add Item to Cart mobile skip")
    public void userClicksOnAddItemToCartMobileSkip() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.scrollToElement(productDetailPage.addtocart);
            productDetailPage.addtocart.isDisplayed();
            BrowserUtils.clickWithJS(productDetailPage.addtocart);
        }
    }

    @Then("User asserts items in popup is {string} qty or item")
    public void userAssertsItemsInPopupIsQtyItem(String inputAssert) {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            String ItemName = driver.findElement(By.xpath("(//a[@title='Go to Product: " + inputAssert + "'])[3]")).getText();
            Assert.assertEquals(inputAssert, ItemName);
        }
    }

    @Then("User change qty from {int} to {int} in PDP")
    public void userChangeQtyFromToInPdp(Integer qty1, Integer qty2) {
        productDetailPage.pdpQTYIncrease.click();
    }

    @Then("User change qty from {int} to {int} in PDP tablet and desktop skip")
    public void userChangeQtyFromToInPdpTabletAndDesktopSkip(Integer int1, Integer int2) {
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            productDetailPage.pdpQTYIncrease.click();
        }
    }

    @When("User asserts {string} bed size displayed on PDP")
    public void userAssertsBedSizeDisplayedOnPdp(String mattressSize) {
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
    public void userChangesBedSizeInPdpToOnesNotCurrentlyDisplayedMattressAndAssertsChange(List<String> size) {
        for (String eachSize : size) {
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//li /a[@class='swatchanchor " + eachSize + "']")));
            BrowserUtils.sleep(2);
            String mattressOnPage = driver.findElement(By.cssSelector("h1[itemprop]")).getText();
            Assert.assertTrue(mattressOnPage.toUpperCase().contains(eachSize.toUpperCase()));
        }
    }

    @When("User asserts {string} color displayed on PDP")
    public void userAssertsColorDisplayedOnPdp(String color) {
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
    public void userChangesColorSchemeInPdpToOnesNotCurrentlyDisplayedByDifferentColorsAndAssertsChange(List<String> colors) {
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
    public void userChangesColorSchemeInQuickViewAndAssertsChangeMobileSkipIncluded(List<String> colors) {
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
    public void userClicksOnHeartIconInPdp() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            productDetailPage.heartIconPDPDeskTopTablet.click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            productDetailPage.heartIconPDPMobile.click();
        }
    }
}
