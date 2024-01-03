package cucumber.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class starHealth_junit {
	
	public static WebDriver driver;

    @Before
    public void setup() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");

        // Create a new instance of the WebDriver (in this case, ChromeDriver)
        driver = new EdgeDriver();
    }

    @After
    public void close() {
        // Close the WebDriver after each scenario
        if (driver != null) {
            driver.quit();
        }
    }
	@Given("User launches the Star Health application with {string}")
	public void user_launches_the_star_health_application_with(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.starhealth.in/");
		driver.manage().window().maximize();
	}

	@Given("User waits for the Welcome to Star Health pop-up and closes it")
	public void user_waits_for_the_welcome_to_star_health_pop_up_and_closes_it() throws InterruptedException {
//		WebElement close = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/button/span/span/svg/path"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(close));
//	        close.click();

	}

	@When("User validates the Star Health home page title using a JUnit assertion")
	public void user_validates_the_star_health_home_page_title_using_a_j_unit_assertion() {
	    // Write code here that turns the phrase above into concrete actions
		String expected = "Star Health Insurance: Medical, Accident and Travel insurance policies";
		assertEquals(driver.getTitle(),expected);
	}

	@When("User clicks on the Buy Now button")
	public void user_clicks_on_the_buy_now_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[2]/div/button/span")).click();
	}

	@When("User types Name as {string}")
	public void user_types_name_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"fullname\"]")).sendKeys(string);
	}

	@When("User types Phone as {string}")
	public void user_types_phone_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(string);
	}

	@When("User types the PIN as {string}")
	public void user_types_the_pin_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(string);
	}


	@When("User stypes Email as {string}")
	public void user_selects_the_option(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(string);
	}

	@When("User sees the Plan for My Family page")
	public void user_sees_the_plan_for_my_family_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"userDetails-form\"]/div/div/div/div[1]/div/div/div[2]/div/button")).click();
	}

	@When("User validates that the Email is the same as the previously entered Email using a JUnit assertion")
	public void user_validates_that_the_mobile_number_is_the_same_as_the_previously_entered_number_using_a_j_unit_assertion() {
	    // Write code here that turns the phrase above into concrete actions
		String expected = "123@gmail.com";
		 WebElement input = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		assertEquals(input.getAttribute("value"),expected);
	}

	@When("User clicks on the Star Health logo")
	public void user_clicks_on_the_star_health_logo() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/div/nav[1]/div/div/a/span/img"));
	}



	@Then("The user should have completed the Buy Now flow successfully")
	public void the_user_should_have_completed_the_buy_now_flow_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user buys health insurance");
	}

}
