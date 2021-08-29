package Day10_081521;

import Reusable_classes.Reusable_method;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Action_Item_5 {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {

//step 1: locate the file path where you saved it
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/AI5.xls"));
//create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/AI5_results.xls"), readableFile);
//Step 2: accessing the excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);
//Step 3: row count will return all the rows which is not empty
        int rowCount = writableSheet.getRows();
System.out.println(rowCount);
//set the driver
        WebDriver driver = Reusable_method.setDriver();
      //  List<WebElement> sizes = driver.findElements(By.xpath("//span[@class='_29GwyLL9tJIABAZ0llJMdA']"));

//call the for loop to iterate through your test data from excel
        for (int i = 1; i < 2; i++){

            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();


            //navigate to website
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(2500);
            //close pop up
            Reusable_method.clickMethod(driver, "//*[@id='closeModal']", "pop up close button");
            //hover over to the Men tab
            //Reusable_method.mouseHover(driver, "//*[@class='MegaMenu_primaryNav__3G5fm']", 1, "mens tab");
            Thread.sleep(2500);
            //click on polo link
            Reusable_method.clickMethod(driver, "//*[contains(text(),'Polos')]", "polos");
            Thread.sleep(2500);
            //scroll down and click the first polo
            Reusable_method.scrolling(driver, "scroll(0,500)");
            Reusable_method.clickMethod(driver, "//*[@class='cdS1D9eKI7bXTMHp5xeAA']",  "first polo");
            Thread.sleep(2500);

            //click on desired size
            for (int j = 0; j < 6; j++) {
                String sizeFromSite = Reusable_method.getTextByIndex(driver,"//*[@class='_3Z6l4Kfa0scQ-64JelWSie']",(j),"size");
                System.out.println(size);

                if (sizeFromSite.equals(size)) {
                    Reusable_method.getTextByIndex(driver,"//*[@class='_3Z6l4Kfa0scQ-64JelWSie']",j,"size");
                    break;
                    //"//*[text()='Checkout as Guest']"
                }
            }//end of inner for loop
            Thread.sleep(2500);

        }//end of inner for loop

        //outside of loop quit the driver
        driver.quit();
    }//end of main
}//end of java class



