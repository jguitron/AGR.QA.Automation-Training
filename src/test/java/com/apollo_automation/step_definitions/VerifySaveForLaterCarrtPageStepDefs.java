package com.apollo_automation.step_definitions;
import com.ashley_ui.pages.PDPPage;
import com.ashley_ui.pages.SearchPage;
import com.ashley_ui.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class VerifySaveForLaterCarrtPageStepDefs {
    WebDriver driver = Driver.getDriver();
    com.ashley_ui.pages.SearchPage SearchPage = new SearchPage();
    com.ashley_ui.pages.PDPPage PDPPage = new PDPPage();



    @Then("User search's Honey-Can-Do {int} Piece Jar Storage Set in search bar")
    public void user_search_s_honey_can_do_piece_jar_storage_set_in_search_bar(Integer int1) {
        SearchPage.searchBar.sendKeys("Honey-Can-Do {int} Piece Jar Storage Set");
    }

    @Then("User clicks on Honey-Can-Do {int} Piece Jar Storage Set")
    public void user_clicks_on_honey_can_do_piece_jar_storage_set(Integer int1) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids, , large']")).click();
        Thread.sleep(3000);

    }

    @Then("User clicks save for later button")
    public void user_clicks_save_for_later_button() throws InterruptedException {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,700)");
        PDPPage.SaveItem.click();
    }

    @And("User Logs in")
    public void userLogsIn() throws InterruptedException {
        Thread.sleep(3000);
        PDPPage.EmailAddressLogin.click();
        PDPPage.EmailAddressLogin.sendKeys("jguitron@ashleyfurniture.com");
        PDPPage.PassWordLogin.click();
        PDPPage.PassWordLogin.sendKeys("Tester123!");
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@style='font-weight:bold;']")));
        driver.findElement(By.name("dwfrm_login_login")).click();
    }


    @Then("User asserts total items in cart after save for later")
    public void user_asserts_total_items_in_cart_after_save_for_later() throws InterruptedException {
        Thread.sleep(3000);
        String itemSaved = driver.findElement(By.cssSelector("h2 a[tabindex='0']")).getText();
        String itemExpected =  "Honey-Can-Do 4 Piece Jar Storage Set";
        Assert.assertEquals(itemExpected, itemSaved);
        if (itemExpected.equals(itemSaved))
        {
            System.out.println("Pass");
        }


        }

    }



