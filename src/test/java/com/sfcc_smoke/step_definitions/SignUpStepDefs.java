package com.sfcc_smoke.step_definitions;

import com.sfcc_smoke.pages.AccountPage;
import com.sfcc_smoke.pages.HomePage;
import com.sfcc_smoke.utilities.BrowserUtils;
import com.sfcc_smoke.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignUpStepDefs {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    AccountPage signUp = new AccountPage();
    Actions actions = new Actions(driver);

    @When("User clicks on login button")
    public void userClicksOnLoginLink() {
        homePage.loginButton.click();
    }

    @Then("User then clicks on Login link")
    public void userThenClicksOnLogInLink() {
        homePage.loginLink.click();
    }

    @And("User clicks Create account link")
    public void userClicksCreateAccountLink() {
        actions.moveToElement(signUp.createAccount).build().perform();
        signUp.createAccount.click();
    }

    @Then("User enters personal information")
    public void user_enter_personal_information_with_following_data() {
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
    public void user_confirms_age() {
        signUp.verifyAge.click();
        BrowserUtils.sleep(1);
    }

    @Then("User clicks on Submit button")
    public void user_clicks_on_submit_button() {
        signUp.submitForm.click();
        BrowserUtils.sleep(1);
    }
}
