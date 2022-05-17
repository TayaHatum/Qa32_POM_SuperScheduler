package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WizardScreen extends BaseScreen{
    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    MobileElement skipButton;

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    List<MobileElement> list;



    public HomeScreen skipWizard(){
        should(skipButton,15);
         skipButton.click();

         return new HomeScreen(driver);
    }

    public HomeScreen skipIfWizard(){
        //should(skipButton,25);
       // if(driver.findElements(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")).size()>0)
            if(list.size()>0){

            skipButton.click();
        }
        return new HomeScreen(driver);
    }

    public HomeScreen skipIfWizard2(){

        if(isDisplayedWithExp(skipButton)){

            skipButton.click();
        }
        return new HomeScreen(driver);
    }
}
