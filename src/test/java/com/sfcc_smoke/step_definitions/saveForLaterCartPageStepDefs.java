package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class saveForLaterCartPageStepDefs {
    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();



    @Then("User clicks save for later button")
    public void user_clicks_save_for_later_button() {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,700)");
        productDetailPage.SaveItem.click();
    }

    @And("User Logs in")
    public void userLogsIn() {
        BrowserUtils.sleep(3);
        productDetailPage.EmailAddressLogin.click();
        productDetailPage.EmailAddressLogin.sendKeys("jguitron@ashleyfurniture.com");
        productDetailPage.PassWordLogin.click();
        productDetailPage.PassWordLogin.sendKeys("Tester123!");
        BrowserUtils.sleep(3);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@style='font-weight:bold;']")));
        driver.findElement(By.name("dwfrm_login_login")).click();
    }

    @Then("User asserts total items in cart after save for later")
    public void user_asserts_total_items_in_cart_after_save_for_later() {
        BrowserUtils.sleep(3);
        String itemSaved = driver.findElement(By.cssSelector("h2 a[tabindex='0']")).getText();
        String itemExpected = "Honey-Can-Do 4 Piece Jar Storage Set";
        Assert.assertEquals(itemExpected, itemSaved);
        if (itemExpected.equals(itemSaved)) {
            System.out.println("Pass");

        }
    }
}



