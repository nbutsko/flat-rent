package test;

import driver.DriverSingleton;
import org.testng.annotations.AfterClass;

public class AbstractTest {

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        DriverSingleton.closeDriver();
    }
}
