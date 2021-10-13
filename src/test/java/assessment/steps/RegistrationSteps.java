package assessment.steps;

import io.cucumber.java.bs.A;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.OTPPage;
import pageObjects.RoleSelectionPage;
import pageObjects.AdditionalDetailsPage;

import commonLibs.BrowserFactory;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class RegistrationSteps {

    private final LoginPage loginPage;
    private final RegisterPage registrationPage;
    private final OTPPage otpPage;
    private final RoleSelectionPage roleSelectionPage;
    private final AdditionalDetailsPage addtionalDetailsPage;

    public RegistrationSteps(String browserName) {
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegisterPage(driver);
        this.otpPage = new OTPPage(driver);
        this.roleSelectionPage = new RoleSelectionPage(driver);
        this.addtionalDetailsPage = new AdditionalDetailsPage(driver);
    }

    @Step("The client opens the login page on #browserName browser")
    public void openLoginPage() {
        this.loginPage.openLoginPage("https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/");
    }

    @Step("The client clicks to registration link to navigate to registration page " +
            "and and input all the basic info to create account")
    public void openRegistrationPage() throws AWTException, InterruptedException {
        this.loginPage.navigateToRegisterPage();
        this.registrationPage.checkRegisterPageOpenSuccess();
        this.registrationPage.inputInformationAndContinue(
                "User 69", "test", "automationtest696969@gmail.com","12346969",
                "Facebook", "123456"
        );
        this.otpPage.inputOTP();
    }

    @Step("The client choose the director role")
    public void selectDirectorRole() {
        this.roleSelectionPage.chooseTheDirectorRole();
    }

    @Step("The client selects country and solutions")
    public void selectCountryAnsSolutions() throws AWTException {
        this.addtionalDetailsPage.selectRegisteredCountry("Singapore");
        this.addtionalDetailsPage.selectSolutions(new String[]{"iste", "saepe", "harum"});
        this.addtionalDetailsPage.clickOnContinueButton();
    }

}
