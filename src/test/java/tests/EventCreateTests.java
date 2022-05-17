package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;


public class EventCreateTests extends AppiumConfiguration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build());
    }

    @Test
    public void createNewEventSuccess(){
       boolean isFabPlusPresent =  new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("TitleNew")
                        .type("NewType")
                        .breaks(3)
                        .wage(80).build())
                .isFabPlusPresent();
        Assert.assertTrue(isFabPlusPresent);
    }
    @Test
    public void createNewEventSuccess2(){
        boolean isFabPlusPresent =  new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Party")
                        .type("Party type")
                        .breaks(2)
                        .wage(55).build())
                .isFabPlusPresent();
        Assert.assertTrue(isFabPlusPresent);
    }
    @AfterClass
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
