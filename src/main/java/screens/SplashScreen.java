package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/app_version_res']")
    MobileElement versionTextView;
   // @FindBy (xpath = "//*[@id='com.example.svetlana.scheduler:id/app_version_res']")

    public String getCurrencyVersion(){
        return versionTextView.getText();
    }

    public LoginScreen checkVersion(String version){
        shouldHave(versionTextView,10,version);
        return new LoginScreen(driver);
    }
}
