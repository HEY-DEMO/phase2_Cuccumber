package cucumber.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.List;

public class testnglinks {
    private WebDriver driver;
    ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test6;
    @BeforeClass
    public void setUp() {
    	htmlReporter = new ExtentSparkReporter("extentReport2.html");

		// create ExtentReport and attach this reports
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void displayAllLinks() {
    	test6 = extentReports.createTest("printing all links in the website", "Test Amazon Search Iphone 15 pro max");
		test6.log(Status.INFO, "Starting test case");
        // Navigate to the website of your choice
        driver.get("https://www.starhealth.in/");

        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Display each link's text and href attribute in the console
        for (WebElement link : links) {
            System.out.println("Text: " + link.getText() + " - URL: " + link.getAttribute("href"));
        }
        test6.pass("printed all the available links in the website");
		test6.log(Status.INFO, "Ending test case");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            extentReports.flush();
        }
    }
}
