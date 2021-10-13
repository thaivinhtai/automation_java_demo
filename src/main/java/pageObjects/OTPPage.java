package pageObjects;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OTPPage {

    private final WebDriver driver;
    private final String firstOTPNumberField;
    private final String resendOTPButton;

    public OTPPage(WebDriver driver) {
        this.driver = driver;
        this.firstOTPNumberField = "//input[@autocomplete=\"one-time-code\"]/../div/div[1]'";
        this.resendOTPButton = "//span[text()=\"Resend OTP\"]";
    }

    public void inputOTP() throws AWTException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.resendOTPButton)));
        TimeUnit.SECONDS.sleep(3);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_3);
        robot.keyRelease(KeyEvent.VK_3);
        robot.keyPress(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_4);
    }

}
