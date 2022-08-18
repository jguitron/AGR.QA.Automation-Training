package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.HomePage;
import com.sfcc_smoke.pages.LandingPage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.ConfigReader;
import com.sfcc_smoke.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignUpStepDefs {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    AccountPage signUp = new AccountPage();
    Actions actions = new Actions(driver);
    LandingPage landingPage = new LandingPage();

    @When("User clicks on login button")
    public void userClicksOnLoginLink() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            homePage.loginButton.click();
        }
        if (ConfigReader.getProperty("platform").equals("mobile") || ConfigReader.getProperty("platform").equals("tablet")) {
            landingPage.mobileMenu.click();
            landingPage.mobileLoginBtn.click();
        }
    }

    @Then("User then clicks on Login link")
    public void userThenClicksOnLogInLink() {
        if (ConfigReader.getProperty("platform").equals("desktop")) {
            homePage.loginLink.click();
        } else {
            System.out.println("Mobile/Tablet views will skip this step");
        }
    }

    @And("User clicks Create account link")
    public void userClicksCreateAccountLink() {
        if (ConfigReader.getProperty("platform").equals("desktop") || ConfigReader.getProperty("platform").equals("tablet")) {
            actions.moveToElement(signUp.createAccount).build().perform();
            signUp.createAccount.click();
        }
        if (ConfigReader.getProperty("platform").equals("mobile")) {
            signUp.createAccountMobile.click();
        }
    }

    @Then("User enters personal information")
    public void userEnterPersonalInformationWithFollowingData() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.name().username() + "@gmail.com";
        String phone = "4126010000";
        String password = "M1" + faker.name().nameWithMiddle() + "#";
        actions.moveToElement(signUp.passwordNew).build().perform();
        signUp.firstName.sendKeys(firstName);
        signUp.lastName.sendKeys(lastName);
        signUp.email.sendKeys(email);
        signUp.confEmail.sendKeys(email);
        signUp.phone.sendKeys(phone);
        signUp.altPhone.sendKeys(phone);
        signUp.passwordNew.sendKeys(password);
        signUp.confPassword.sendKeys(password);
        BrowserUtils.sleep(1);
    }

    @Then("User confirms age")
    public void userConfirmsAge() {
        signUp.verifyAge.click();
        BrowserUtils.sleep(2);
    }

    @Then("User clicks on Submit button if the Environment is non-production")
    public void userClicksOnSubmitButton() {
        String url = System.getProperty("url", ConfigReader.getProperty("url"));
        if (url.contains("staging") || url.contains("development")) {
            signUp.submitForm.click();
            BrowserUtils.waitForPageToLoad(5);
            Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("ashleyfurniture.com/account/"));
        }

    }
}
