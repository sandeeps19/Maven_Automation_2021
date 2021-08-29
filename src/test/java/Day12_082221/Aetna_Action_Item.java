package Day12_082221;

import Reusable_classes.Reusable_method;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Aetna_Action_Item {

    //declare the global variables outside the annotation methods
    WebDriver driver;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    //precondition for express
    @BeforeSuite
    public void setTheDriverAndWorkbook() throws IOException, BiffException {
        //step 1: locate the file path where you save it
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Aetna.xls"));
        //create a writable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Aetna_Results.xls"),readableFile);
        //Step 2: accessing the excel sheet from the workbook
        writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        rowCount = writableSheet.getRows();
        //set the driver
        driver = Reusable_method.setDriver();
    }//end of before suite

    @Test
    public void Aetna() throws InterruptedException, WriteException {
        for (int i = 1; i < 2; i++) {

            //get cell's 2 arguments are column and row
            String zipcode = writableSheet.getCell(0, i).getContents();
            String miles = writableSheet.getCell(1, i).getContents();

            //navigate to express
            driver.navigate().to("https://www.aetna.com/");
            driver.manage().window().fullscreen();
            Thread.sleep(2500);

            //click on Shop for a plan
            Reusable_method.clickMethod(driver, "//*[text()='Shop for a plan']", "Shop for a plan");
            Thread.sleep(2500);

            //click on Medicare
            Reusable_method.clickMethod(driver, "//*[text()='Medicare']", "Medicare");
            Thread.sleep(2500);

            //click on Find a doctor
            Reusable_method.clickMethod(driver, "//*[text()='Find a doctor ']", "Find a doctor ");
            Thread.sleep(2500);

            //click on 2021 Medicare plans you purchase yourself
            Reusable_method.clickMethod(driver, "//*[text()='2021 Medicare plans you purchase yourself']", "2021 Medicare plans you purchase yourself");
            Thread.sleep(2500);

            //send keys to enter a zipcode
            Reusable_method.sendKeysMethod(driver, "//*[@id='medZip']", zipcode, "enter a zipcode");
            Thread.sleep(2500);

            //click zipcode
            Reusable_method.clickMethod(driver, "//a[text()=' (South Ozone Park, NY)']", "zipcode");
            Thread.sleep(2500);

            WebElement Slider = driver.findElement(By.xpath("//*[@class='rz-bar-wrapper']/a[1]"));
            Thread.sleep(3000);

            Actions moveSlider = new Actions(driver);
            Action action = moveSlider.dragAndDropBy(Slider, 30, 0).build();

            action.perform();
        }//end of loop
    }//end of test

    @AfterSuite
    public void writeExcelAndQuitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite
}//end of java class
