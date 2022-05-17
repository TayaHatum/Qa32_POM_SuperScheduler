package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy (xpath = "//android.widget.ImageButton[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logout;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;

    //com.example.svetlana.scheduler:id/nav_fr_logout_img
    //com.example.svetlana.scheduler:id/nav_fr_logout

    public EditCreateEventScreen initCreationEvent(){
        should(fabAdd,10);
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreateEventScreen(driver);
    }

    public boolean isFabPlusPresent(){
        should(fabAdd,20);
        return fabAdd.isDisplayed();

    }

    public HomeScreen openMenu(){
        should(burgerMenu,10);
        burgerMenu.click();
        return this;
    }
    public LoginScreen logout(){
        logout.click();
        return new LoginScreen(driver);
    }



    public HomeScreen checkFabButtonPresent(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }
}
