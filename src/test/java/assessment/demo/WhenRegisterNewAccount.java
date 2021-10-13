package assessment.demo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import assessment.steps.RegistrationSteps;

import java.awt.AWTException;


@RunWith(SerenityRunner.class)
@Narrative(text={"Registration"})
public class WhenRegisterNewAccount {

    @Steps
    RegistrationSteps chrome;

    public WhenRegisterNewAccount() {
        this.chrome = new RegistrationSteps("Chrome");
    }

    @Test
    public void register() throws AWTException, InterruptedException {
        this.chrome.openLoginPage();
        this.chrome.openRegistrationPage();
        this.chrome.selectDirectorRole();
        this.chrome.selectCountryAnsSolutions();
    }
}
