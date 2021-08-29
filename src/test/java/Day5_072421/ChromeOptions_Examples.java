package Day5_072421;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions_Examples {

    public static void main(String[] args) {

        //set the property and path to your chromedriver
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        //options.addArguments("start-maximized"); //maximize options is for windows
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.bing.com");
        driver.manage().window().maximize();

    }//end of main method
}//end of java class
