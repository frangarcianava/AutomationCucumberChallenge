package stepDefinitions;

import constants.Constants;
import driver.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends MyDriver {

    @Before
    public static void setUpDriver(){
        driver = MyDriver.getDriver();
        driver.get(Constants.URL);
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown(){
        driver.quit();
    }
}
