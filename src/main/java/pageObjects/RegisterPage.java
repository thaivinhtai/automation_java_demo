package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {

    private final WebDriver driver;
    private final String fullNameField;
    private final String preferredNameField;
    private final String emailAddressField;
    private final String phoneNumberField;
    private final String hearingField;
    private final String checkbox;
    private final String continueButton;
    private final String vnPhone;
    private final String phoneLocationChosen;
    private final String hearingFromFB;
    private final String referralField;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.fullNameField = "//input[@name='full_name']";
        this.preferredNameField = "//input[@name='preferred_name']";
        this.emailAddressField = "//input[@name='email']";
        this.phoneNumberField = "//input[@name='phone']";
        this.phoneLocationChosen = "//i[@role=\"presentation\"]";
        this.vnPhone = "//div[text()=\"Viet Nam (+84)\"]";
        this.hearingField = "//input[@placeholder='Type to Search or Select any of the following']";
        this.hearingFromFB = "//div[@class=\"q-item__label\"][text()=\"Facebook\"]";
        this.referralField = "//input[@placeholder=\"Enter the referral code or promo code\"]";
        this.checkbox = "//*[@class=\"q-checkbox__truthy\"]/..";
        this.continueButton = "//button[@type='button']";
    }

    public boolean checkRegisterPageOpenSuccess() {
        String title = this.driver.getTitle();
        return title.equals("Let's get started | Aspire");
    }

    public void inputInformationAndContinue(
            String fullName, String preferredName, String emailAddress, String phoneNumber, String hearing,
            String referralCode
            ) {
        this.driver.findElement(By.xpath(this.fullNameField)).sendKeys(fullName);
        this.driver.findElement(By.xpath(this.preferredNameField)).sendKeys(preferredName);
        this.driver.findElement(By.xpath(this.emailAddressField)).sendKeys(emailAddress);
        this.driver.findElement(By.xpath(this.phoneLocationChosen)).click();
        this.driver.findElement(By.xpath(this.vnPhone)).click();
        this.driver.findElement(By.xpath(this.phoneNumberField)).sendKeys(phoneNumber);
        this.driver.findElement(By.xpath(this.hearingField)).sendKeys(hearing);
//        this.driver.findElement(By.xpath(this.referralField)).sendKeys(referralCode);
        this.driver.findElement(By.xpath(this.hearingFromFB)).click();
        this.driver.findElement(By.xpath(this.checkbox)).click();
        this.driver.findElement(By.xpath(this.continueButton)).click();
    }

}
