package Day9_080121;

import Reusable_classes.Reusable_method;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Mlcalc_with_Resuable_concepts {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = Reusable_method.setDriver();

//navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);
        driver.manage().window().maximize();
//clear and enter a purchase price
        Reusable_method.sendKeysMethod(driver,"//*[@id='ma']","400000","Purchase Price");
//clear and enter down payment
        Reusable_method.sendKeysMethod(driver,"//*[@id='dp']","25","Down Payment");

    }//end of main method
}//end of java class
