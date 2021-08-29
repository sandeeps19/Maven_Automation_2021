package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AI2{
    public static void main (String[] args) throws InterruptedException {

        String[] zipCode;
        zipCode= new String[3];
        zipCode [0]= "11410";
        zipCode [1]= "11430";
        zipCode [2]= "11420";

        //set the property and the path to your chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //the driver that I'm going to use for automation
        WebDriver opener= new ChromeDriver();

        for (int i=0; i<zipCode.length; i++) {
            opener.navigate().to("https://www.bing.com");

            opener.manage().window().maximize();
            Thread.sleep(2000);

            opener.findElement(By.xpath("//*[@name='q']")).sendKeys(zipCode[i]);

            opener.findElement(By.xpath("//*[@id='sb_form_go']")).submit();
            Thread.sleep(2000);

            String result= opener.findElement(By.xpath("//*[@id='b_tween']")).getText();
            String[] resultArray= result.split(" ");
            System.out.println("My search number for the zipcode " + zipCode[i]+ " is " + resultArray[0]);

        }//end of for loop
        opener.quit();
    }//end of main method
}//end of java class