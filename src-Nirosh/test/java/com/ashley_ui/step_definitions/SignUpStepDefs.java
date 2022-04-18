package com.ashley_ui.step_definitions;

import com.ashley_ui.pages.HomePage;
import com.ashley_ui.pages.SignUpPage;
import com.ashley_ui.utilities.BrowserUtils;
import com.ashley_ui.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignUpStepDefs {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();
    Actions actions = new Actions(driver);
    HomePageStepDefs mainPageStepDefs = new HomePageStepDefs();

    @Given("user is on Ashley home page")
    public void user_is_on_ashley_home_page() {
        mainPageStepDefs.goToLandingPage();
        mainPageStepDefs.closeiFrame();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginLink() {
        homePage.loginButton.click();
    }

    @Then("user then clicks on Login link")
    public void userThenClicksOnLogInLink() {
        homePage.loginLink.click();
    }

    @And("user clicks Create account link")
    public void userClicksCreateAccountLink() {
        actions.moveToElement(signUpPage.createAccount).build().perform();
        signUpPage.createAccount.click();
    }

    @Then("user enters personal information")
    public void user_enter_personal_information_with_following_data() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.name().username()+"@gmail.com";
        String phone = "4126010000";
        String password = "M1"+faker.name().nameWithMiddle()+"#";

        actions.moveToElement(signUpPage.password).build().perform();
        signUpPage.firstName.sendKeys(firstName);
        signUpPage.lastName.sendKeys(lastName);
        signUpPage.email.sendKeys(email);
        signUpPage.confEmail.sendKeys(email);
        signUpPage.phone.sendKeys(phone);
        signUpPage.altPhone.sendKeys(phone);
        signUpPage.password.sendKeys(password);
        signUpPage.confPassword.sendKeys(password);
        BrowserUtils.sleep(1);
    }

    @Then("user confirms age")
    public void user_confirms_age() {
        signUpPage.verifyAge.click();
        BrowserUtils.sleep(1);
    }

    @Then("user clicks on Submit button")
    public void user_clicks_on_submit_button() {
        signUpPage.submitForm.click();
        BrowserUtils.sleep(1);
    }

}
