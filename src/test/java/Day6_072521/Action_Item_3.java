package Day6_072521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Action_Item_3 {
        public static void main(String[] args) throws InterruptedException {

            String[] zipCode;
            zipCode = new String[3];
            zipCode[0] = "11420";
            zipCode[1] = "11212";
            zipCode[2] = "11040";

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            for (int i = 0; i < zipCode.length; i++) {

                driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
                Thread.sleep(500);

                driver.findElements(By.xpath("//*[@class='buttonText-3DCCO']")).get(1).click();
                Thread.sleep(2000);

                WebElement location_search_field = driver.findElement(By.xpath("//*[@id='location-search']"));
                location_search_field.clear();
                location_search_field.sendKeys(zipCode[i]);

                WebElement location_search_button = driver.findElement(By.xpath("//*[@id='location-search-cta']"));
                location_search_button.submit();
                Thread.sleep(2000);

                List<WebElement> address = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));

                if (i == 0)
                    address.get(0).click();
                else if (i == 1)
                    address.get(1).click();
                else if (i == 2)
                    address.get(2).click();
                Thread.sleep(1000);

                String address_part1 = driver.findElement(By.xpath("(//div[@class='address-2PZwW'])/div[1]")).getText();
                String address_part2 = driver.findElement(By.xpath("(//div[@class='address-2PZwW'])/div[2]")).getText();

                System.out.println("The address when i = " + i + " and zipcode = " + zipCode[i] + " is " + address_part1 + " " + address_part2);

                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll (0,1000)");
                Thread.sleep(1000);

                String result = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println("The hours are\n" + result + "\n");

            }//end of loop
            driver.quit();
        }// end of main method
    }//end of java class
