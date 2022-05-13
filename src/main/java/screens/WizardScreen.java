package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class WizardScreen extends BaseScreen{
    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    MobileElement skipButton;

    public HomeScreen skipWizard(){
        should(skipButton,15);
         skipButton.click();

         return new HomeScreen(driver);
    }

    public HomeScreen skipIfWizard(){
        should(skipButton,25);
        if(skipButton.isDisplayed()){

            skipButton.click();
        }
        return new HomeScreen(driver);
    }
}
