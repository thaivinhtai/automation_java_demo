package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdditionalDetailsPage {

    private final WebDriver driver;
    private final String companyRegisteredField;
    private final String solutionsField;
    private final String selections;
    private final String continueButton;

    public AdditionalDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.companyRegisteredField = "//div[@placeholder=\"Select any of the following\"]/../../div[contains(@class,\"field__append\")]/i";
        this.solutionsField = "//div[@placeholder=\"Select applicable options\"]/../../div[contains(@class,\"field__append\")]/i";
        this.selections = "//div[text()=\"{0}\"]/../..";
        this.continueButton = "//span[./text()=\"Continue\"]";
    }

    public void selectRegisteredCountry(String country) throws AWTException {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.companyRegisteredField)));
        this.driver.findElement(By.xpath(this.companyRegisteredField)).click();
        String xpathCountry = this.selections.replace("{0}", country);
        Actions actions = new Actions(this.driver);
        Robot robot = new Robot();
        while (true){
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
            try {
                this.driver.findElement(By.xpath(xpathCountry)).click();
                break;
            }
            catch (Exception ignored) {
            }
        }

    }

    public void selectSolutions(String[] solutions) throws AWTException {
        Robot robot = new Robot();
        this.driver.findElement(By.xpath(this.solutionsField)).click();
        Actions actions = new Actions(this.driver);
        for (String solution : solutions) {
            String xpathSolutions = this.selections.replace("{0}", solution);
            this.driver.findElement(By.xpath(xpathSolutions));
            actions.moveToElement(this.driver.findElement(By.xpath(xpathSolutions))).click().perform();

//            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//            try {
//                this.driver.findElement(By.xpath(xpathSolutions));
//                actions.moveToElement(this.driver.findElement(By.xpath(xpathSolutions))).click().perform();
//            }
//            catch (Exception ignored){
//            }

        }
        this.driver.findElement(By.xpath(this.solutionsField)).click();
    }

    public void clickOnContinueButton() {
        this.driver.findElement(By.xpath(this.continueButton)).click();
    }
}

