package Day4_071821.Bing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_Action_Item_2 {

    public static void main(String[] args) throws InterruptedException {

        String[] SmartPhones; SmartPhones= new String[3];
        SmartPhones[0]= "Samsung";
        SmartPhones[1]= "Huawei";
        SmartPhones[2]= "Apple";

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the webdriver
        WebDriver opener = new ChromeDriver();

        for (int i=0; i<SmartPhones.length; i++) {
            opener.navigate().to("https://www.bing.com");

            //Maximize window
            opener.manage().window().maximize();
            Thread.sleep(2000);

            opener.findElement(By.xpath("//*[@name='q']")).sendKeys(SmartPhones[i]);

            opener.findElement(By.xpath("//*[@id='sb_form_go']")).submit();
            Thread.sleep(2000);

            //capture results
            String result = opener.findElement(By.xpath("//*[@class='sb_count']")).getText();

            String[] arrayResult = result.split(" ");
            System.out.println("My search number for smart phone company " + SmartPhones[i] + " is " + arrayResult[0]);

        }//end of loop

       //opener.quit();

    }//end of main method
}//end of action item
