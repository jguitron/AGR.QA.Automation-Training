package com.sfcc_smoke.step_definitions;

import com.github.javafaker.Faker;
import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.CartPage;
import com.sfcc_smoke.pages.DataFieldPage;
import com.sfcc_smoke.pages.ProductDetailPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CartPageDefs {

    CartPage cartPage = new CartPage();
    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    String platform = ConfigReader.getProperty("platform");

    AccountPage accountPage = new AccountPage();

    DataFieldPage dataFieldPage = new DataFieldPage();

    @When("User clicks on Confirm button to confirm the zip code")
    public void user_clicks_confirm_zipcode_button() {
        BrowserUtils.waitForPageToLoad(5);
        if (cartPage.confirmZipPopUp.isDisplayed()) {
            BrowserUtils.clickWithJS(cartPage.btnConfirmZip);
            BrowserUtils.sleep(3);
        }
    }

    @When("User uncheck Protection Plan check box")
    public void user_uncheck_PP_checkbox() {
        BrowserUtils.waitForPageToLoad(5);
        if (cartPage.pp_checkbox.isSelected()) {
            BrowserUtils.clickWithJS(cartPage.pp_checkbox_cont);
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User check Protection Plan check box")
    public void user_check_PP_checkbox() {
        if (cartPage.pp_checkbox.isSelected()) {
            System.out.println("do nothing");
        } else
            cartPage.pp_checkbox.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User uncheck Handy Item check box")
    public void user_uncheck_handy_checkbox() {
        if (cartPage.handy_checkbox.isSelected()) {
            cartPage.handy_checkbox.click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User check Handy Item check box")
    public void user_check_handy_checkbox() {
        if (cartPage.handy_checkbox.isSelected()) {
            System.out.println("do nothing");
        } else
            BrowserUtils.clickWithJS(cartPage.handy_checkbox);
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User verifies that {string} is added to cart")
    public void user_verifies_that_FPP_added_cart(String ProtectionPlan) {
        Assert.assertEquals("Furniture $49.99", cartPage.pplink1.getText());
        Assert.assertEquals("Outdoor $179.99", cartPage.pplink2.getText());
        Assert.assertEquals("Adjustable Base $149.99", cartPage.pplink3.getText());
        Assert.assertEquals("King Adjustable Base $199.99", cartPage.pplink4.getText());
    }

    @When("User verifies that Protection Plan is not available")
    public void user_verifies_that_FPP_unavailable() {
        Assert.assertEquals("OUR APOLOGIES: Protection plans are currently unavailable", cartPage.nofpp.getText());
    }

    @When("User verifies that protection plan is available on cart")
    public void user_verifies_that_protection_plan_is_available_on_cart() {
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel1.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel2.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel3.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel4.getText());
    }

    @When("User verifies that protection plan is selected")
    public void user_verifies_PP_selected() {
        Assert.assertTrue(cartPage.ppckbx1.isSelected());
    }

    @When("User verifies that protection plan is unselected")
    public void user_verifies_PP_unselected() {
        Assert.assertFalse(cartPage.ppckbx1.isSelected());
        Assert.assertFalse(cartPage.ppckbx2.isSelected());
        Assert.assertFalse(cartPage.ppckbx3.isSelected());
        Assert.assertFalse(cartPage.ppckbx4.isSelected());
    }

    @When("User clicks on Secure Check out button")
    public void user_clicks_secure_checkout_button() {
        cartPage.secureckoutbtn.click();
        BrowserUtils.sleep(2);
    }

    @Then("User changes Qty from {string} to {string} in cart")
    public void user_changes_qty_from_to_in_cart(String qtyNumberStart, String qtyNumberChange) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.qtySelect.click();
            BrowserUtils.scrollToElement(cartPage.qtySelect);
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity'] /option[@value='"+qtyNumberChange+"']")).click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            BrowserUtils.sleep(3);
            cartPage.qtySelect.click();
            BrowserUtils.scrollToElement(cartPage.qtySelect);
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity'] /option[@value='"+qtyNumberChange+"']")).click();
        }
    }

    @Then("Assert cart is reflecting {string} QTY change")
    public void assert_cart_is_reflecting_qty_change(String expectedQty) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        String MyCart = driver.findElement(By.xpath("//h1[@class='cart-title']")).getText();
        Assert.assertEquals(expectedQty, MyCart);
    }

    @When("User Removes item from cart")
    public void user_removes_item_from_cart() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            cartPage.removeitem.click();
            cartPage.removeitem_YesBtn.click();
        } else if (ConfigReader.getProperty("platform").equals("tablet")) {
            cartPage.removeItem_BtnMobileTablet.click();
            cartPage.removeitem_YesBtn.click();
        } else if (ConfigReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(cartPage.removeItem_BtnMobileTablet);
            BrowserUtils.clickWithJS(cartPage.removeItem_BtnMobileTablet);
            cartPage.removeitem_YesBtn.click();
        }
    }

    @Then("User Validates cart is {int} qty")
    public void user_validates_cart_is_qty(Integer int1) {
        String actualQty = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        String expectedQty = "Your Shopping Cart is Empty";
        Assert.assertTrue(expectedQty, actualQty.contains("Your Shopping Cart is Empty"));
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

    @Then("User asserts {string} saved items with {string}")
    public void user_asserts_saved_items_with(String SavedItem, String assertSaved) {
        String savedItem = driver.findElement(By.xpath("//h2 /*[contains(@href,'"+assertSaved+"')]")).getText();
        Assert.assertTrue(SavedItem.contains(savedItem));
    }

    @Then("User asserts {string} saved items in cart")
    public void user_asserts_saved_items_in_cart(String SavedItem) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        BrowserUtils.waitForPageToLoad(5);
        String savedItem = driver.findElement(By.xpath("//div[@class='name'] /div /a[@title='Go to Product: "+SavedItem+"']")).getText();
        Assert.assertTrue(SavedItem.contains(savedItem));
    }
    @Then("User asserts {string} saved items in cart mobile skip")
    public void user_asserts_saved_items_in_cart_mobile_skip(String item) {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            String SavedItem = cartPage.savedInCart.getText();
            String expectedItem = item;
            Assert.assertEquals(expectedItem, SavedItem);
        }
    }

    @Then("User clicks save for later button")
    public void user_clicks_save_for_later_button() {
        if (ConfigReader.getProperty("platform").equals("mobile") || ConfigReader.getProperty("platform").equals("tablet"))  {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,700)");
        productDetailPage.SaveItemMobile.click();
        } else if (ConfigReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.clickWithJS(productDetailPage.SaveItem);
        }
    }

    @Then("User validates the tax amount on CartPage")
    public void user_validate_tax_on_cart() {
        BrowserUtils.sleep(2);
        if (platform.equals("desktop")) {
            String zipcode = cartPage.cartzipcodelink.getText();
            String taxvalue = cartPage.taxValueCart.getText();
            taxvalue = taxvalue.replace("$", "");
            double finaltaxvalue = Double.parseDouble(taxvalue);
            BrowserUtils.scrollToElement(cartPage.taxesCart);
            if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
                Assert.assertTrue(finaltaxvalue == 0.00);
            } else {
                Assert.assertTrue(finaltaxvalue > 0);
            }
        }
        if (platform.equals("mobile") || (platform.equals("tablet"))) {
            String zipcode = cartPage.cartzipcodelinkMob.getText();
            String taxvalue = cartPage.taxValueCart.getText();
            taxvalue = taxvalue.replace("$", "");
            double finaltaxvalue = Double.parseDouble(taxvalue);
            BrowserUtils.scrollToElement(cartPage.taxesCart);
            if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
                Assert.assertTrue(finaltaxvalue == 0.00);
            } else {
                Assert.assertTrue(finaltaxvalue > 0);
            }
        }
    }

    @Then("User changes the delivery {string} by clicking on zipcode link from Cart Page")
    public void user_change_the_zipcode_in_cart(String zipcode) {
        BrowserUtils.waitForPageToLoad(5);
        if (platform.equals("desktop")) {
            BrowserUtils.sleep(2);
            BrowserUtils.scrollToElement(cartPage.cartzipcodelink);
            BrowserUtils.clickWithJS(cartPage.cartzipcodelink);
            BrowserUtils.sleep(3);
            BrowserUtils.clickWithJS(cartPage.changeLocationZipCodePopUpTextBox);
            BrowserUtils.sleep(3);
            cartPage.changeLocationZipCodePopUpTextBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(1);
        }
        if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.sleep(3);
            BrowserUtils.scrollToElement(cartPage.cartzipcodelinkMob);
            BrowserUtils.clickWithJS(cartPage.cartzipcodelinkMob);
            BrowserUtils.sleep(3);
            cartPage.changeLocationZipCodePopUpTextBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(1);
        }
    }
    @Then("User clicks add to cart from Wish List")
    public void user_clicks_add_to_cart_from_wish_list() {
        cartPage.addToCartwishListButton.click();
    }
    @Then("User asserts user name on account page reflects {string}")
    public void user_asserts_user_name_on_account_page_reflects(String userName) {
        String onPageUserName = cartPage.userNameOnAccount.getText().trim();
        Assert.assertTrue(onPageUserName.contains(userName));
    }
    @Then("User asserts email-address on account page reflects {string}")
    public void user_asserts_email_address_on_account_page_reflects(String email) {
        String emailOnPage= cartPage.emailOnAccount.getText();
        Assert.assertEquals(email,emailOnPage);
    }
    @Then("User asserts phone number on account page reflects {string}")
    public void user_asserts_phone_number_on_account_page_reflects(String phoneNumber) {
        String phoneNumberOnPage = cartPage.phoneNumberOnAccount.getText();
        Assert.assertEquals(phoneNumber,phoneNumberOnPage);
    }
    @When("User inputs generated new address data into fields")
    public void user_inputs_generated_new_address_data_into_fields() {
        Faker faker = new Faker();
        dataFieldPage.setAddressName(faker.address().firstName());
        dataFieldPage.setFirstName(faker.name().firstName());
        dataFieldPage.setLastName(faker.name().lastName());
        dataFieldPage.setAddress(faker.address().streetAddressNumber());
        dataFieldPage.setCity(faker.address().city());
        dataFieldPage.setZipCode(faker.address().zipCode());
    }
    @When("User enters personal information into create new address tab")
    public void user_enters_personal_information_into_create_new_address_tab () {
        accountPage.addressNameAdd.sendKeys(dataFieldPage.getAddressName());
        accountPage.firstNameAddressAdd.sendKeys(dataFieldPage.getFirstName());
        accountPage.lastNameAddressAdd.sendKeys(dataFieldPage.getLastName());
        accountPage.fullAddressAdd.sendKeys(dataFieldPage.getAddress());
        accountPage.cityAddressAdd.sendKeys(dataFieldPage.getCity());
        accountPage.stateSelectionAddressAdd.click();
        accountPage.stateAddressAdd.click();
        accountPage.zipCodeAddressAdd.sendKeys(dataFieldPage.getZipCode());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        accountPage.zipCodeAddressAdd.sendKeys(dataFieldPage.getZipCode());
        accountPage.phoneNumberAddressAdd.sendKeys("(800) 275-8777");
        accountPage.applyButtonAddressAdd.click();
        accountPage.submitButtonAddressAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String nameValidation = driver.findElement(By.xpath("//*[contains(text(),'"+ dataFieldPage.getAddressName()+"')]")).getText();
        Assert.assertEquals(nameValidation,dataFieldPage.getAddressName());
    }
        @When("User deletes saved address")
        public void user_deletes_saved_address () {
        driver.findElement(By.xpath("//a[contains(@href, 'Delete?AddressID="+dataFieldPage.getAddressName()+"')]")).click();
        driver.switchTo().alert().accept();
        }
}
