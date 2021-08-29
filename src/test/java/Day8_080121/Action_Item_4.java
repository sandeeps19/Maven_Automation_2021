package Day8_080121;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Action_Item_4 {

    public static void main (String[] args) throws InterruptedException {

        ArrayList<String> first_name = new ArrayList<String>();
        first_name.add("Joe");
        first_name.add("Sam");
        first_name.add("Rob");
        ArrayList<String> last_name = new ArrayList<String>();
        last_name.add("Doe");
        last_name.add("Thee");
        last_name.add("Will");
        ArrayList<String> dob = new ArrayList<String>();
        dob.add("04011991");
        dob.add("07021998");
        dob.add("05031980");
        ArrayList<String> memberId = new ArrayList<String>();
        memberId.add("600000");
        memberId.add("800000");
        memberId.add("100001");
        ArrayList<String> planId = new ArrayList<String>();
        planId.add("100000");
        planId.add("200000");
        planId.add("300000");

        //sets up webdriver manager to handle dynamic browser variations
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options= new ChromeOptions();
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();

        for (int i=0; i <3 ; i++) {

            //navigates to website
            driver.navigate().to("https://www.uhc.com");

            Thread.sleep(2000);

            try {
                //clicks on Find a doctor option
                System.out.println("Clicking on Find a doctor option");
                WebElement find_a_doctor = driver.findElement(By.xpath("//a[text()='Find a doctor']"));
                find_a_doctor.click();
            } catch (Exception Error) {
                //prints out this error message if it unable to click on Find a doctor option
                System.out.println("Unable to click on Find a doctor option " + Error);
            }

            Thread.sleep(2000);

            try{
                //closes popup if it appears
                System.out.println("Clicking on close button of popup");
                WebElement popup_exit= driver.findElement(By.xpath("//*[@id='ip-close']"));
                popup_exit.click();
            } catch (Exception Error) {
                //prints out this error message if popup does not appear
                System.out.println("Unable to click on close button of popup " + Error);
            }

            //scrolls to dropdown menu
            JavascriptExecutor jse= (JavascriptExecutor)driver;
            jse.executeScript( "scroll (0,400)");

            try{
                //clicks on Select your plan to sign in
                System.out.println("Clicking on Select your plan to sign in");
                WebElement plans_dropdown_menu= driver.findElement (By.xpath("//*[contains(text(),'Select your plan to sign in')]"));
                plans_dropdown_menu.click();
            } catch (Exception Error) {
                //prints out this error message if it is unable to click on Select your plan to sign in
                System.out.println("Unable to click on Select your plan to sign in " + Error);
            }

            try{
                //clicks on Medicaid plan option
                System.out.println("Clicking on Medicaid plan option");
                WebElement medicaid_plan = driver.findElement(By.xpath("//*[text()='Medicaid plan']"));
                medicaid_plan.click();
            } catch (Exception Error) {
                //prints out this error message if it is unable to click on Medicaid plan option
                System.out.println("Unable to click on Medicaid plan option " + Error);
            }

            Thread.sleep(2000);

            //gets list of all window handles
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switches to the second tab
            driver.switchTo().window(tabs.get(1));

            try{
                //clicks on Register Now option
                System.out.println("Clicking on Register Now option");
                WebElement register_now = driver.findElement(By.xpath("//*[text()='Register Now']"));
                register_now.click();
            } catch (Exception Error) {
                //prints out this error message if it is unable to click on Register Now option
                System.out.println("Unable to click on Register Now option " + Error);
            }

            Thread.sleep(2000);

            //sends the current name of the first_name list
            WebElement first_name_field = driver.findElement(By.xpath("//*[@id='firstName']"));
            first_name_field.sendKeys(first_name.get(i));

            //sends the current name of the last_name list
            WebElement last_name_field = driver.findElement(By.xpath("//*[@id='lastName']"));
            last_name_field.sendKeys(last_name.get(i));

            //selects the month of the current dob
            WebElement dob_month_box = driver.findElement(By.xpath("//*[@id='dob_month_input']"));
            Select select_month = new Select(dob_month_box);
            select_month.selectByValue(dob.get(i).substring(0,2));

            //sends the day of the current dob
            WebElement dob_day_box = driver.findElement(By.xpath("//*[@id='dob_day']"));
            dob_day_box.sendKeys(dob.get(i).substring(2,4));

            //sends the year of the current dob
            WebElement dob_year_box = driver.findElement(By.xpath("//*[@id='dob_year']"));
            dob_year_box.sendKeys(dob.get(i).substring(4,8));

            //sends the current member ID of the memberId list
            WebElement memberId_field = driver.findElement(By.xpath("//*[@id='memberId']"));
            memberId_field.sendKeys(memberId.get(i));

            //sends the current group number of the planID list
            WebElement groupNumber_field = driver.findElement(By.xpath("//*[@id='groupNumber']"));
            groupNumber_field.sendKeys(planId.get(i));

            try {
                //Submits form
                System.out.println("Submitting form");
                WebElement continue_button = driver.findElement(By.xpath("//*[@id='submitBtn']"));
                continue_button.submit();
            } catch (Exception Error) {
                //prints out this error message if it is unable to submit the form
                System.out.println("Unable to submit form " + Error);
            }

            Thread.sleep(2000);

            try {
                //Captures the error code
                System.out.println("Capturing error code");
                String id_error = driver.findElement(By.xpath("//*[@id='plainText_error']")).getText();
                System.out.println(id_error);
            } catch (Exception Error) {
                //prints out this error message if it is unable to capture the error code
                System.out.println("Unable to capture error " + Error);
            }

            System.out.println("\n");

            driver.close();
            driver.switchTo().window(tabs.get(0));

        }//end of for loop

        driver.quit();

    }//end of main method

}//end of java class