package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RoleSelectionPage {

    private final WebDriver driver;
    private final String directorRole;

    public RoleSelectionPage(WebDriver driver) {
        this.driver = driver;
        this.directorRole = "//img[@src=\"img/auth/director.svg\"]/../..";
    }

    public void chooseTheDirectorRole() {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.directorRole)));
        this.driver.findElement(By.xpath(this.directorRole)).click();
    }

}
