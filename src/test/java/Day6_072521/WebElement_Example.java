package Day6_072521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_Example {
    public static void main(String[] args) throws InterruptedException {

        //set up Webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.get("https://www.mortgagecalculator.org");
        //few seconds to wait
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //store home value as a webElement for shortcut so you can reuse the locator again
        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the existing data on home value
        homeVal.clear();
        //enter new value on home value field
        homeVal.sendKeys("450000");

    }//end of main method
}//end of java class
