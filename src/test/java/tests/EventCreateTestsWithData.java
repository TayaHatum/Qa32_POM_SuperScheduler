package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import models.Event;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class EventCreateTestsWithData extends AppiumConfiguration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build());
    }


    @Test
    public void addNewEventWithAction(){
        new HomeScreen(driver)
                .initCreationEvent()
                .actionData()
                .createNewEvent(Event.builder()
                        .title("TitleNew")
                        .type("NewType")
                        .breaks(3)
                        .wage(80).build())
                .isFabPlusPresent();

    }
}
