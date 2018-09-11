package tests;

import engine.Driver;
import engine.utils.LoggerUtil;
import engine.utils.TestListener;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class UiTestRunner  {
    Driver driver = new Driver();

    @BeforeClass
    public final void beforeClass(){
        LoggerUtil.startTestCase("Test case: " + getClass().getName() + " is running...");
    }
    @BeforeTest
    public final void beforeTest(){
        driver.start();
    }

    @AfterTest
    public final void afterTest(){
        driver.quit();
    }

    @AfterClass
    public final void afterClass(){
        LoggerUtil.endTestCase();
    }
}
