package tests;

import engine.Driver;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class UiTestRunner  {
    Driver driver = new Driver();

    @BeforeTest
    public final void beforeTest(){
        driver.start();
    }

    @AfterTest
    public final void afterTest(){
        driver.quit();
    }

}
