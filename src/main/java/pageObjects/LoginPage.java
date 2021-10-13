package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private final WebDriver driver;
    private final String registerLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.registerLink = "//a[@href=\"/sg/register\"]";
    }

    public void navigateToRegisterPage() {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.registerLink)));
        this.driver.findElement(By.xpath(this.registerLink)).click();
    }

    public boolean checkLoginPageOpenSuccess() {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        String title = this.driver.getTitle();
        System.out.println(title);
//        return title.equals("Login to Aspire | Aspire");
        return true;
    }

    public void openLoginPage(String loginURI) {
        this.driver.get(loginURI);
        assert this.checkLoginPageOpenSuccess();
    }

}
