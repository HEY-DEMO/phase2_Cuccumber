package cucumber.stepdefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class starhealth_testng {
	ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test1, test2 ,test3,test4,test5;
	
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        // Setup code that needs to run once before all tests in the suite
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        // Setup code that needs to run before each test class
    	htmlReporter = new ExtentSparkReporter("extentReport.html");

		// create ExtentReport and attach this reports
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.starhealth.in/");
    }

    // Other common setup or teardown methods can be added here

    @AfterSuite
    public void afterSuite() {
        // Teardown code that needs to run once after all tests in the suite
        if (driver != null) {
            driver.quit();
            extentReports.flush();
        }
    }
    @Test(priority =0)
    public void yourTest() {
    	test1 = extentReports.createTest("checking logo", "starhealth website");
		test1.log(Status.INFO, "Starting test case");
    	 WebElement logo = driver.findElement(By.xpath("//img[@alt='Star Health Logo']"));
    	 test1.pass("finding logo");
         // Get the value of the alt attribute
         String altText = logo.getAttribute("alt");

         // Assert that the alt attribute value is 'Star Health'
         Assert.assertEquals(altText, "Star Health Logo", "Alt text does not match expected value");
         test1.pass("checking whether the logo is same");
         test1.log(Status.INFO, "ending test case");
    }
    @Test(priority=1)
    public void hovercursor() throws InterruptedException {
    	test2 = extentReports.createTest("hovering cursor", "selecting option");
		test2.log(Status.INFO, "Starting test case");
    	 WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
    	 test2.pass("hovering over plans");
         // Create an instance of the Actions class
         Actions actions = new Actions(driver);
         // Perform the hover action
         actions.moveToElement(elementToHover).perform();
         driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/a")).click();
         test2.pass("clicking on my family option");
         test2.log(Status.INFO, "ending test case");
    }
    @Test(priority=2)
    @Parameters({"name", "mobile","email"})
    public void enterFamilyDetails( String name, String mobile, String email) throws InterruptedException {
    	test3 = extentReports.createTest("typing the details", "tenstNG parameterized");
		test3.log(Status.INFO, "Starting test case");
    	Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(name);
       driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]")).sendKeys(mobile);
       driver.findElement(By.xpath("//*[@id=\"pinCode\"]")).sendKeys(email);
       test3.pass("Entered the details");
       driver.navigate().back();
       test3.log(Status.INFO, "Ending test case");
    }
    @Test(priority = 3)
    public void validateSocialMediaLinks() throws IOException {
    	test4 = extentReports.createTest("validating media links", "using testng assertions");
    	test4.log(Status.INFO, "Starting test case");
    	FileInputStream fileInputStream = new FileInputStream(new File("Book1.xlsx"));
    	Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("sheet1");

        String twitterLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/footer/div/div[2]/div[1]/div[2]/a[4]")).getAttribute("href");
        String facebookLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/footer/div/div[2]/div[1]/div[2]/a[1]")).getAttribute("href");
        String linkedInLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/footer/div/div[2]/div[1]/div[2]/a[3]")).getAttribute("href");
        String youTubeLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/footer/div/div[2]/div[1]/div[2]/a[2]")).getAttribute("href");
        String instagramLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/footer/div/div[2]/div[1]/div[2]/a[5]")).getAttribute("href");
        // Read social media details from Excel sheet
        
        String excelTwitterLink = sheet.getRow(3).getCell(0).getStringCellValue() ;
        String excelFacebookLink =sheet.getRow(0).getCell(0).getStringCellValue() ; 
        String excelLinkedInLink =sheet.getRow(2).getCell(0).getStringCellValue() ; // Code to read LinkedIn link from Excel
        String excelYouTubeLink =sheet.getRow(1).getCell(0).getStringCellValue() ; // Code to read YouTube link from Excel
        String excelInstagramLink = sheet.getRow(4).getCell(0).getStringCellValue() ;// Code to read Instagram link from Excel

        // Validate social media links using TestNG assertions
        Assert.assertEquals(twitterLink, excelTwitterLink, "Twitter link is not as expected");
       Assert.assertEquals(facebookLink, excelFacebookLink, "Facebook link is not as expected");
        Assert.assertEquals(linkedInLink, excelLinkedInLink, "LinkedIn link is not as expected");
        Assert.assertEquals(youTubeLink, excelYouTubeLink, "YouTube link is not as expected");
        Assert.assertEquals(instagramLink, excelInstagramLink, "Instagram link is not as expected");
        test4.pass("checked the links at the footer of the page");
        test4.log(Status.INFO, "Starting test case");

    }
    @Test(priority=4)
    public void validateTwitterPage() throws InterruptedException {
    	test5 = extentReports.createTest("twitter page validation", "accessing twitter from starhealth");
    	test5.log(Status.INFO, "Starting test case");
        // Navigate to the main website

        // Click on the Twitter link (replace the selector with the actual one on your webpage)
        WebElement twitterLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/footer/div/div[2]/div[1]/div[2]/a[4]/span/img"));
        twitterLink.click();

        String twitterUrl = driver.getCurrentUrl();
        Assert.assertTrue(twitterUrl.contains("starhealthins"), "Twitter page URL should contain 'starhealthins'");
        test5.pass("opened twiiter page and checked for starhealth in URL");
        test5.log(Status.INFO, "ending test case");
    }


}
