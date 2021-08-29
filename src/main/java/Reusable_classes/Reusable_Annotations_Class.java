package Reusable_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Reusable_Annotations_Class {
    public static WebDriver driver;

    @BeforeSuite
    public void setTheDriver() throws IOException {
        driver = Reusable_method.setDriver();
    }//end of before suite

    @AfterSuite
    public void quiteSession(){
        driver.quit();
    }//end of after suite
}//end of java class
